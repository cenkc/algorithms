package algorithms.shortestpath;

import java.util.*;

/**
 *
 * https://java2blog.com/dijkstra-java/
 *
 */
public class Dijkstra {

    public static void main(String[] args) {
        directedExample();
        undirectedExample();
    }

    /**
     *                    6
     *        (E) ---------------- (B)
     *       / |  \                 |
     *   10 /  |   \ 21             | 7
     *     /   |    \               |
     *   (F)   | 11 (A)            (C)
     *     \   |    /
     *    7 \  |   / 18
     *       \ |  /
     *        (D)
     *
     */
    private static void undirectedExample() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addNeighbour(new Edge(18, nodeA, nodeD));
        nodeA.addNeighbour(new Edge(21, nodeA, nodeE));
        nodeB.addNeighbour(new Edge(7, nodeB, nodeC));
        nodeB.addNeighbour(new Edge(6, nodeB, nodeE));
        nodeC.addNeighbour(new Edge(7, nodeC, nodeB)); // B-C
        nodeD.addNeighbour(new Edge(18, nodeD, nodeA)); // A-D
        nodeD.addNeighbour(new Edge(11, nodeD, nodeE));
        nodeD.addNeighbour(new Edge(7, nodeD, nodeF));
        nodeE.addNeighbour(new Edge(21, nodeE, nodeA)); // A-E
        nodeE.addNeighbour(new Edge(6, nodeE, nodeB)); // B-E
        nodeE.addNeighbour(new Edge(11, nodeE, nodeD)); // D-E
        nodeE.addNeighbour(new Edge(10, nodeE, nodeF));
        nodeF.addNeighbour(new Edge(7, nodeF, nodeD)); // D-F
        nodeF.addNeighbour(new Edge(10, nodeF, nodeE)); // E-F

        Dijkstra shortestPath = new Dijkstra();
        shortestPath.computeShortestPaths(nodeA);

        System.out.println("from A to B, Shortest Path is : "+shortestPath.getShortestPathTo(nodeB) + " and min. distance is : "+nodeB.getTotalWeight());
        System.out.println("from A to C, Shortest Path is : "+shortestPath.getShortestPathTo(nodeC) + " and min. distance is : "+nodeC.getTotalWeight());
        System.out.println("from A to D, Shortest Path is : "+shortestPath.getShortestPathTo(nodeD) + " and min. distance is : "+nodeD.getTotalWeight());
        System.out.println("from A to E, Shortest Path is : "+shortestPath.getShortestPathTo(nodeE) + " and min. distance is : "+nodeE.getTotalWeight());
        System.out.println("from A to F, Shortest Path is : "+shortestPath.getShortestPathTo(nodeF) + " and min. distance is : "+nodeF.getTotalWeight());

    }

    /**
     *
     *           10
     *    (A) -------> (C)
     *     |         /  |  \
     *     |       /    |   \
     *  17 |   5 /    9 |    \ 11
     *     |   /        |     \
     *     ˅ ˅          ˅      ˅
     *    (B) -------> (D) ---> (E)
     *           17         6
     *
     */
    private static void directedExample() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        nodeA.addNeighbour(new Edge(10, nodeA, nodeC));
        nodeA.addNeighbour(new Edge(17, nodeA, nodeB));
        nodeC.addNeighbour(new Edge(5, nodeC, nodeB));
        nodeC.addNeighbour(new Edge(9, nodeC, nodeD));
        nodeC.addNeighbour(new Edge(11, nodeC, nodeE));
        nodeB.addNeighbour(new Edge(1, nodeB, nodeD));
        nodeD.addNeighbour(new Edge(6, nodeD, nodeE));

        Dijkstra shortestPath = new Dijkstra();
        shortestPath.computeShortestPaths(nodeA);

        System.out.println("from A to B, Shortest Path is : "+shortestPath.getShortestPathTo(nodeB) + " and min. distance is : "+nodeB.getTotalWeight());
        System.out.println("from A to C, Shortest Path is : "+shortestPath.getShortestPathTo(nodeC) + " and min. distance is : "+nodeC.getTotalWeight());
        System.out.println("from A to D, Shortest Path is : "+shortestPath.getShortestPathTo(nodeD) + " and min. distance is : "+nodeD.getTotalWeight());
        System.out.println("from A to E, Shortest Path is : "+shortestPath.getShortestPathTo(nodeE) + " and min. distance is : "+nodeE.getTotalWeight());
    }

    public void computeShortestPaths(Node sourceNode) {
        sourceNode.setTotalWeight(0);
        Queue<Node> pq = new PriorityQueue<>();

        pq.add(sourceNode);
        sourceNode.setVisited(true);

        while ( ! pq.isEmpty()) {
            Node currentNode = pq.poll();
            for (Edge edge : currentNode.getAdjacencyList()) {
                Node destinationNode = edge.getDestinationNode();
                if ( ! destinationNode.isVisited()) {
                    double currTotalWeight = currentNode.getTotalWeight() + edge.getWeight();
                    // edge relaxation
                    if (currTotalWeight < destinationNode.getTotalWeight()) {
                        pq.remove(destinationNode);
                        destinationNode.setTotalWeight(currTotalWeight);
                        destinationNode.setPrevNode(currentNode);
                        pq.add(destinationNode);
                    }
                }
            }
            currentNode.setVisited(true);
        }
    }

    public List<Node> getShortestPathTo(Node destinationNode) {
        List<Node> path = new ArrayList<>();
        for (Node node=destinationNode; node != null; node = node.getPrevNode()) {
            path.add(node);
        }
        Collections.reverse(path);
        return path;
    }

    public static class Node implements Comparable<Node> {
        private String name;
        private List<Edge> adjacencyList;
        private boolean visited;
        private Node prevNode;
        private double totalWeight;

        public Node(String name) {
            this.name = name;
            this.adjacencyList = new ArrayList<>();
            this.totalWeight = Double.MAX_VALUE;
        }
        public void addNeighbour (Edge edge) {
            this.adjacencyList.add(edge);
        }

        @Override
        public String toString() {
            return this.name;
        }

        @Override
        public int compareTo(Node otherNode) {
            return Double.compare(this.totalWeight, otherNode.getTotalWeight());
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Edge> getAdjacencyList() {
            return adjacencyList;
        }

        public void setAdjacencyList(List<Edge> adjacencyList) {
            this.adjacencyList = adjacencyList;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public Node getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node prevNode) {
            this.prevNode = prevNode;
        }

        public double getTotalWeight() {
            return totalWeight;
        }

        public void setTotalWeight(double totalWeight) {
            this.totalWeight = totalWeight;
        }
    }
    public static class Edge {

        private double weight;
        private Node sourceNode;
        private Node destinationNode;

        public Edge(double weight, Node sourceNode, Node destinationNode) {
            this.weight = weight;
            this.sourceNode = sourceNode;
            this.destinationNode = destinationNode;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public Node getSourceNode() {
            return sourceNode;
        }

        public void setSourceNode(Node sourceNode) {
            this.sourceNode = sourceNode;
        }

        public Node getDestinationNode() {
            return destinationNode;
        }

        public void setDestinationNode(Node destinationNode) {
            this.destinationNode = destinationNode;
        }
    }
}
