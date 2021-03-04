package interviewquestions.amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Treasure Island
 * https://leetcode.com/discuss/interview-question/347457
 * Related Topics : Depth-first Search, Breadth-first Search
 *
 * You have a map that marks the location of a treasure island.
 * Some of the map area has jagged rocks and dangerous reefs.
 * Other areas are safe to sail in.
 * There are other explorers trying to find the treasure.
 * So you must figure out a shortest route to the treasure island.
 *
 * Assume the map area is a two dimensional grid,
 * represented by a matrix of characters.
 * You must start from the top-left corner of the map
 * and can move one block up, down, left or right at a time.
 * The treasure island is marked as 'X' in a block of the matrix.
 * X will not be at the top-left corner.
 * Any block with dangerous rocks or reefs will be marked as 'D'.
 * You must not enter dangerous blocks. You cannot leave the map area.
 * Other areas O are safe to sail in. The top-left corner is always safe.
 * Output the minimum number of steps to get to the treasure.
 *
 * Example:
 *
 * Input:
 * [['O', 'O', 'O', 'O'],
 *  ['D', 'O', 'D', 'O'],
 *  ['O', 'O', 'O', 'O'],
 *  ['X', 'D', 'D', 'O']]
 *
 * Output: 5
 * Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
 *
 * created by cenkc on 8/8/2020
 */
public class TreasureIsland {

    private static int distance = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[][] island = {
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}};
        // int hops = traverseIslandDepthFirstSearch(island);

//        int[] c = {5,8};
//        System.out.println(c[0]);
//        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//
//        for (int[] dir : dirs) {
//            //System.out.println(Arrays.toString(dir));
//            System.out.println(dir[0] + "-" + dir[1]);
//        }

        int hops = traverseIslandBreadthFirstSearch(island);
        System.out.println("hops = " + hops);
    }

    private static int traverseIslandBreadthFirstSearch(char[][] island) {
        // https://leetcode.com/discuss/interview-question/347457/Amazon-or-OA-2019-or-Treasure-Island/371649
        if (island == null || island.length == 0) return 0;

        int steps = 0;

        boolean[][] visited = new boolean[island.length][island[0].length]; // initially, they are all 'false'
        visited[0][0] = true;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // up, down, right, left, respectively

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0}); // starting point, which is upper left corner of the island grid

        while ( ! q.isEmpty()) {
            int size = q.size();
//            steps++;
            for (int i = 0; i < size; i++) {
                int[] coord = q.poll();
                if (island[coord[0]][coord[1]] == 'X') {
//                    return steps - 1;
                    return steps;
                }
                for (int[] dir : directions) {
                    int newX = coord[0] + dir[0];
                    int newY = coord[1] + dir[1];
                    if (newX >= 0 && newX < island.length &&
                            newY >= 0 && newY < island[0].length &&
                            island[newX][newY] != 'D' &&
                            ! visited[newX][newY]) {

                        q.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            steps++;
        }
        return steps - 1;
    }

    static class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int traverseIslandDepthFirstSearch(char[][] island) {
        // https://leetcode.com/discuss/interview-question/347457/Amazon-or-OA-2019-or-Treasure-Island/416552
        // https://leetcode.com/discuss/interview-question/347457

        if (island == null) {
            return -1;
        }
        boolean[][] visited = new boolean[island.length][island[0].length];

        dfs(island, 0, 0, visited, 0);
        return distance;
    }

    private static void dfs(char[][] island, int x, int y, boolean[][] visited, int levelDistance) {
        if (island == null ||
                x < 0 || x >= island.length ||
                y < 0 || y >= island.length ||
                island[x][y] == 'D' ||
                visited[x][y]) {
            return;
        }
        if (island[x][y] == 'X') {
            distance = Math.min(distance, levelDistance);
            return;
        }
        
        visited[x][y] = true;

        dfs(island, x + 1, y, visited, levelDistance + 1); // Up
        dfs(island, x - 1, y, visited, levelDistance + 1); // Down
        dfs(island, x, y + 1, visited, levelDistance + 1); // Right
        dfs(island, x, y - 1, visited, levelDistance + 1); // Left

        visited[x][y] = false;
    }
}
