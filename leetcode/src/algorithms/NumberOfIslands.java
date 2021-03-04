package algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 * Difficulty : Medium
 * Related Topics : Depth-first Search, Breadth-first Search, Union Find
 *
 * Given a 2d grid map of '1's (land) and '0's (water),
 * count the number of islands.
 * An island is surrounded by water and is formed by
 * connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 * created by cenkc on 8/8/2020
 */
public class NumberOfIslands {

    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // up, down, right, left

    public static void main(String[] args) {
/*
        // expected output = 1
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
*/

        // expected output = 3
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};


        // don't call dfs & bfs at the same time, latter will fail because of marking 1s to 0s

        //System.out.println(numOfIslandsDFS(grid));
        System.out.println(numOfIslandsBFS(grid));
    }

    /**
     * Runtime: 4 ms, faster than 26.87% of Java online submissions for Number of Islands.
     * Memory Usage: 42.3 MB, less than 50.33% of Java online submissions for Number of Islands.
     * @param grid
     * @return
     */
    private static int numOfIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int counter = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    q.add(new int[]{i ,j});
                    grid[i][j] = '0';
                    while ( ! q.isEmpty()) {
                        int[] current = q.poll();
                        for (int[] dir : directions) {
                            int row = current[0] + dir[0];
                            int col = current[1] + dir[1];
                            if (row >= 0 && row < grid.length &&
                                    col >= 0 && col < grid[0].length &&
                                    grid[row][col] == '1') {
                                q.add(new int[]{row, col});
                                grid[row][col] = '0';
                            }
                        }
                    }
                    counter++;
                }
            }
        }

        return counter;
    }

    private static int numOfIslandsDFS(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int counter = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    counter++;
                }
            }
        }
        return counter;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;
        grid[i][j] = '0'; // mark as visited
        for (int[] dir : directions) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}
