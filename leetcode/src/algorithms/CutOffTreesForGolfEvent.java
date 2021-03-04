package algorithms;

import java.util.*;

/**
 * 675. Cut Off Trees for Golf Event
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/
 * Difficulty : Hard
 * Related Topics : Breadth-first Search
 *
 * You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:
 *
 * 0 represents the obstacle can't be reached.
 * 1 represents the ground can be walked through.
 * The place with number bigger than 1 represents a tree can be walked through,
 * and this positive number represents the tree's height.
 * In one step you can walk in any of the four directions top, bottom, left and right
 * also when standing in a point which is a tree you can decide whether or not to cut off the tree.
 *
 * You are asked to cut off all the trees in this forest
 * in the order of tree's height - always cut off the tree with lowest height first.
 * And after cutting, the original place has the tree will become a grass (value 1).
 *
 * You will start from the point (0, 0)
 * and you should output the minimum steps you need to walk to cut off all the trees.
 * If you can't cut off all the trees, output -1 in that situation.
 *
 * You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [1,2,3],
 *  [0,0,4],
 *  [7,6,5]
 * ]
 * Output: 6
 *
 *
 * Example 2:
 *
 * Input:
 * [
 *  [1,2,3],
 *  [0,0,0],
 *  [7,6,5]
 * ]
 * Output: -1
 *
 *
 * Example 3:
 *
 * Input:
 * [
 *  [2,3,4],
 *  [0,0,5],
 *  [8,7,6]
 * ]
 * Output: 6
 * Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
 *
 *
 * Constraints:
 *
 * 1 <= forest.length <= 50
 * 1 <= forest[i].length <= 50
 * 0 <= forest[i][j] <= 10^9
 *
 * created by cenkc on 8/10/2020
 */
public class CutOffTreesForGolfEvent {

    // https://leetcode.com/problems/cut-off-trees-for-golf-event/discuss/434958/Java-PriorityQueue-%2B-BFS

    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // up, down, right, left

    class Tree {
        int x;
        int y;
        int height;
        public Tree(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    public int cutOffTree(List<List<Integer>> forest) {

        if (forest == null || forest.size() == 0) return 0;

        // we are going to add data to the pq like this: (tree.startX, tree.startY, tree.height)
        PriorityQueue<Tree> pq = new PriorityQueue<>((a, b) -> a.height - b.height); // comparator

        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                Integer height = forest.get(i).get(j);
                if (height > 0) {
                    pq.offer(new Tree(i, j, height)); // (tree.startX, tree.startY, tree.height)
                }
            }
        }

        int counter = 0;
        int startX = 0;
        int startY = 0;

        while ( ! pq.isEmpty()) {
            Tree currentTree = pq.poll();

            int steps = bfs(forest, startX, startY, currentTree.x, currentTree.y);
            if (steps == -1) {
                return -1;
            }

            counter += steps;
            startX = currentTree.x;
            startY = currentTree.y;
        }

        return counter;
    }

    private int bfs(List<List<Integer>> forest, int startX, int startY, int currentX, int currentY) {
        if (startX == currentX && startY == currentY) return 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});

        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        visited[startX][startY] = true;

        int step = 0;

        while ( ! q.isEmpty()) {
            step++;

            final int size = q.size(); // watch out!! size will change in each iteration
            for (int i = 0; i < size; i++) { // don't use q.size() here
                int[] startPos = q.poll();
                for (int[] dir : directions) {
                    int nextX = startPos[0] + dir[0];
                    int nextY = startPos[1] + dir[1];
                    if (nextX == currentX && nextY == currentY) {
                        return step;
                    }
                    if (nextX >= 0 && nextX < forest.size() &&
                            nextY >= 0 && nextY < forest.get(0).size() &&
                            ! visited[nextX][nextY] &&
                            forest.get(nextX).get(nextY) != 0) {
                        visited[nextX][nextY] = true;
                        q.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        List<List<Integer>> forest = new ArrayList<>();

/*
        forest.add(Arrays.asList(1,2,3));
        forest.add(Arrays.asList(0,0,4));
        forest.add(Arrays.asList(7,6,5));
        // expected output = 6
*/
/*
        forest.add(Arrays.asList(1,2,3));
        forest.add(Arrays.asList(0,0,0));
        forest.add(Arrays.asList(7,6,5));
        // expected output = -1
*/
/*
        forest.add(Arrays.asList(2,3,4));
        forest.add(Arrays.asList(0,0,5));
        forest.add(Arrays.asList(8,7,6));
        // expected output = 6
*/
        forest.add(Arrays.asList(54581641,64080174,24346381,69107959));
        forest.add(Arrays.asList(86374198,61363882,68783324,79706116));
        forest.add(Arrays.asList(668150,92178815,89819108,94701471));
        forest.add(Arrays.asList(83920491,22724204,46281641,47531096));
        forest.add(Arrays.asList(89078499,18904913,25462145,60813308));
        // expected output = 57

        CutOffTreesForGolfEvent main = new CutOffTreesForGolfEvent();
        int result = main.cutOffTree(forest);
        System.out.println("result = " + result);
    }

}
