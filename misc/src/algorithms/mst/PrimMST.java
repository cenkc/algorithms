package algorithms.mst;

import java.util.*;

public class PrimMST {

    public static void main(String[] args) {
        undirectedExample();
    }

    private static void undirectedExample() {

        /**
         *                0
         *           (B) ---- (E)
         *           /|        | \
         *     10  /  | 3    1 |   \ 8
         *       /    |        |     \
         *     /   1  |   8    |   9   \
         *   (A)-----(C)------(F)------(H)
         *      \     |       /|      /
         *     4 \   2|    2/  |6   / 12
         *         \  |   /    |  /
         *          \ | /      |/
         *           (D)------(G)
         *                 7
         *
         * Starting from A (doesn't make a difference)
         *     A->C = 1
         *     C->D = 2
         *     D->F = 2
         *     F->E = 1
         *     E->B = 0
         *     F->G = 6
         *     E->H = 8
         *     --------
         *   TOTAL  = 20
         */

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");

        // Node A's adjacency
        nodeA.addNeighbour(new Edge(10, nodeA, nodeB));
        nodeA.addNeighbour(new Edge(1, nodeA, nodeC));
        nodeA.addNeighbour(new Edge(4, nodeA, nodeD));
        // Node B's adjacency
        nodeB.addNeighbour(new Edge(10, nodeB, nodeA));
        nodeB.addNeighbour(new Edge(3, nodeB, nodeC));
        nodeB.addNeighbour(new Edge(0, nodeB, nodeE));
        // Node C's adjacency
        nodeC.addNeighbour(new Edge(1, nodeC, nodeA));
        nodeC.addNeighbour(new Edge(3, nodeC, nodeB));
        nodeC.addNeighbour(new Edge(2, nodeC, nodeD));
        nodeC.addNeighbour(new Edge(8, nodeC, nodeF));
        // Node D's adjacency
        nodeD.addNeighbour(new Edge(4, nodeD, nodeA));
        nodeD.addNeighbour(new Edge(2, nodeD, nodeC));
        nodeD.addNeighbour(new Edge(2, nodeD, nodeF));
        nodeD.addNeighbour(new Edge(7, nodeD, nodeG));
        // Node E's adjacency
        nodeE.addNeighbour(new Edge(0, nodeE, nodeB));
        nodeE.addNeighbour(new Edge(1, nodeE, nodeF));
        nodeE.addNeighbour(new Edge(8, nodeE, nodeH));
        // Node F's adjacency
        nodeF.addNeighbour(new Edge(1, nodeF, nodeE));
        nodeF.addNeighbour(new Edge(8, nodeF, nodeC));
        nodeF.addNeighbour(new Edge(2, nodeF, nodeD));
        nodeF.addNeighbour(new Edge(6, nodeF, nodeG));
        nodeF.addNeighbour(new Edge(9, nodeF, nodeH));
        // Node G's adjacency
        nodeG.addNeighbour(new Edge(7, nodeG, nodeD));
        nodeG.addNeighbour(new Edge(6, nodeG, nodeF));
        nodeG.addNeighbour(new Edge(12, nodeG, nodeH));
        // Node H's adjacency
        nodeH.addNeighbour(new Edge(8, nodeH, nodeE));
        nodeH.addNeighbour(new Edge(9, nodeH, nodeF));
        nodeH.addNeighbour(new Edge(12, nodeH, nodeG));

        PrimMST primMST = new PrimMST();
        primMST.computeMST(nodeA);

    }

    private void computeMST(Node sourceNode) {
        Queue<Edge> pq = new PriorityQueue<>();

        for (Edge edge : sourceNode.getAdjacencyList()) {
            pq.add(edge);
        }

        sourceNode.setVisited(true);

        int minCost = 0;
        while ( ! pq.isEmpty()) {
            Edge currentEdge = pq.poll();

            if (currentEdge.destinationNode.isVisited()) {
                continue;
            }
            currentEdge.destinationNode.setVisited(true);
            System.out.println("currentEdge = " + currentEdge);
            minCost += currentEdge.getWeight();

            for (Edge adjEdgeOfCurrEdgesDestNode : currentEdge.getDestinationNode().getAdjacencyList()) {
                pq.add(adjEdgeOfCurrEdgesDestNode);
            }
        }

        System.out.println("minCost = " + minCost);
    }

    private static void Prim() {

    }

    static class Node implements Comparable<Node> {
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
            // returns -1 when this.totalWeight < otherNode.getTotalWeight()
            // returns  1 when this.totalWeight > otherNode.getTotalWeight()
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
    public static class Edge implements Comparable<Edge> {

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

        @Override
        public int compareTo(Edge otherEdge) {
            return Double.compare(this.weight, otherEdge.getWeight());
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "weight=" + weight +
                    ", sourceNode=" + sourceNode +
                    ", destinationNode=" + destinationNode +
                    '}';
        }
    }
}
