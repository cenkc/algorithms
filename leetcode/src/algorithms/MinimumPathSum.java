package algorithms;

/**
 * 64. Minimum Path Sum
 * https://leetcode.com/problems/minimum-path-sum/
 * Difficulty : Medium
 * Related Topics : Array, Dynamic Programming
 *
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 *
 *
 * Example 1:
 *  ___ ___ ___
 * | 1 | 3 | 1 |
 *  --- --- ---
 * | 1 | 5 | 1 |
 *  --- --- ---
 * | 4 | 2 | 1 |
 *  --- --- ---
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 *
 * created by Cenk Canarslan on 2021-02-08
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}}; // 7
//        int[][] grid = new int[][]{{1,2,3},{4,5,6}}; // 12
        MinimumPathSum minimumPathSum = new MinimumPathSum();

        int minPathSum = minimumPathSum.minPathSum(grid);
        System.out.println("minPathSum = " + minPathSum);

        int minPathSumOptimized = minimumPathSum.minPathSumOptimized(grid);
        System.out.println("Optimized minPathSum = " + minPathSumOptimized);
    }

    /**
     * Optimized solution
     *
     * Dynamic Programming
     * Time Complexity : O(m*n)
     * Space Complexity : O(1) (in-place, because we're NOT using an auxiliary DS)
     *
     * Runtime: 2 ms, faster than 84.01% of Java online submissions
     * Memory Usage: 41.7 MB, less than 69.87% of Java online submissions
     *
     * @param grid
     * @return
     */
    public int minPathSumOptimized(int[][] grid) {

        int rows = grid.length;
        int columns = grid[0].length;

        // fill first column with consecutive sums
        for (int i = 1; i < columns; i++) {
            grid[0][i] = grid[0][i-1] + grid[0][i];
        }

        // fill first row with consecutive sums
        for (int i = 1; i < rows; i++) {
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

        return grid[rows-1][columns-1];
    }

    /**
     * Dynamic Programming
     * Time Complexity : O(m*n)
     * Space Complexity : O(m*n) (not-in-place, because we're using an auxiliary DS)
     *
     * Runtime: 2 ms, faster than 84.01% of Java online submissions
     * Memory Usage: 42 MB, less than 28.99% of Java online submissions
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {

        int rows = grid.length;
        int columns = grid[0].length;

        int[][] aux = new int[rows][columns];

        // fill starting cell in aux
        aux[0][0] = grid[0][0];

        // fill first column with consecutive sums
        for (int i = 1; i < columns; i++) {
            aux[0][i] = aux[0][i-1] + grid[0][i];
        }

        // fill first row with consecutive sums
        for (int i = 1; i < rows; i++) {
            aux[i][0] = aux[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                aux[i][j] = grid[i][j] + Math.min(aux[i-1][j], aux[i][j-1]);
            }
        }

        return aux[rows-1][columns-1];
    }

}
