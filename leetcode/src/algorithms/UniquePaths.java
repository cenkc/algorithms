package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 * Difficulty : Medium
 * Related Topics : Array, Dynamic Programming
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start'(S) in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 *
 * Example 1:
 *
 *  ___ ___ ___ ___ ___ ___ ___
 * | S |   |   |   |   |   |   |
 *  --- --- --- --- --- --- ---
 * |   |   |   |   |   |   |   |
 *  --- --- --- --- --- --- ---
 * |   |   |   |   |   |   | F |
 *  --- --- --- --- --- --- ---
 *
 *
 * Input: m = 3, n = 7
 * Output: 28
 * Example 2:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * Example 3:
 *
 * Input: m = 7, n = 3
 * Output: 28
 * Example 4:
 *
 * Input: m = 3, n = 3
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 109.
 *
 *
 * created by Cenk Canarslan on 2021-02-11
 */
public class UniquePaths {

    @Test
    public void testUniquePaths() {

        assertEquals(3,uniquePathsDPBottomUpTargetTopLeft(3, 2));
        assertEquals(6,uniquePathsDPBottomUpTargetTopLeft(3, 3));
        assertEquals(28,uniquePathsDPBottomUpTargetTopLeft(3, 7));

        assertEquals(3,uniquePathsDPBottomUpTargetBottomRight(3, 2));
        assertEquals(6,uniquePathsDPBottomUpTargetBottomRight(3, 3));
        assertEquals(28,uniquePathsDPBottomUpTargetBottomRight(3, 7));

        assertEquals(3,uniquePathsRecursion(3, 2));
        assertEquals(6,uniquePathsRecursion(3, 3));
        assertEquals(28,uniquePathsRecursion(3, 7));

        assertEquals(3,uniquePathsRecursionWithMemoization(3, 2));
        assertEquals(6,uniquePathsRecursionWithMemoization(3, 3));
        assertEquals(28,uniquePathsRecursionWithMemoization(3, 7));

    }

    /**
     * Tabulation or Bottom-Up (top-left --> bottom-rigth)
     * Time Complexity= O(m*n), Space Complexity= O(m*n)
     *
     * Runtime: 1 ms, faster than 14.80% of Java online submissions for Unique Paths.
     * Memory Usage: 37.6 MB, less than 14.05% of Java online submissions for Unique Paths.
     *
     *  ___ ___ ___ ___ ___ ___ ___
     * | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
     *  --- --- --- --- --- --- ---
     * | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
     *  --- --- --- --- --- --- ---
     * | 1 | 3 | 6 | 10| 15| 21| 28|
     *  --- --- --- --- --- --- ---
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsDPBottomUpTargetBottomRight(int m, int n) {
        int[][] dp = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 || col == 0) {
                    dp[row][col] = 1;
                } else {
                    dp[row][col] = dp[row-1][col] + dp[row][col-1];
                }

            }
        }
        return dp[m-1][n-1];
    }

    /**
     * Tabulation or Bottom-Up (bottom-rigth --> top-left)
     * Time Complexity= O(m*n), Space Complexity= O(m*n)
     *
     * Runtime: 1 ms, faster than 14.80% of Java online submissions for Unique Paths.
     * Memory Usage: 38.1 MB, less than 6.46% of Java online submissions for Unique Paths.
     *
     *  ___ ___ ___ ___ ___ ___ ___
     * | 28| 21| 15| 10| 6 | 3 | 1 |
     *  --- --- --- --- --- --- ---
     * | 7 | 6 | 5 | 4 | 3 | 2 | 1 |
     *  --- --- --- --- --- --- ---
     * | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
     *  --- --- --- --- --- --- ---
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsDPBottomUpTargetTopLeft(int m, int n) {
        int[][] dp = new int[m][n];
        for (int row = m-1; row >= 0; row--) {
            for (int col = n-1; col >= 0; col--) {
                if (row == m-1 || col == n-1) {
                    dp[row][col] = 1;
                } else {
                    dp[row][col] = dp[row+1][col] + dp[row][col+1];
                }
            }
        }
        return dp[0][0];
    }

    /**
     * Recursion
     *
     * !! Time Limit Exceeded !!
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsRecursion(int m, int n) {
        int[][] mem = new int[m][n];
        return solve(m-1, n-1);
    }

    private int solve(int row, int col) {
        if (row == 0 || col == 0) {
            return 1;
        }
        return solve(row-1, col) + solve(row, col-1);
    }

    /**
     * Recursion with Memoization
     *
     * Runtime: 1 ms, faster than 14.80% of Java online submissions for Unique Paths.
     * Memory Usage: 37.6 MB, less than 14.05% of Java online submissions for Unique Paths.
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsRecursionWithMemoization(int m, int n) {
        int[][] mem = new int[m][n];
        return solveWithMem(m-1, n-1, mem);
    }

    private int solveWithMem(int row, int col, int[][] mem) {
        if (row == 0 || col == 0) {
            return 1;
        }
        if (mem[row][col] == 0) {
            mem[row][col] = solveWithMem(row-1, col, mem) + solveWithMem(row, col-1, mem);
        }
        return mem[row][col];
    }

}
