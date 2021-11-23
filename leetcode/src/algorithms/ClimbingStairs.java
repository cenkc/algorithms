package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 * Difficulty : Easy
 * Related Topics : Math, Dynamic Programming, Memoization
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * Constraints:
 *
 *     1 <= n <= 45
 *
 * created by Cenk Canarslan on 2021-11-24
 */
public class ClimbingStairs {

    @Test
    public void testClimbingStars() {
        assertEquals(5, climbStairs(4));
        assertEquals(3, climbStairs(3));
        assertEquals(8, climbStairs(5));
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
     * Memory Usage: 37.7 MB, less than 21.29% of Java online submissions for Climbing Stairs.
     *
     * hint: it's almost the same as Fibonacci Numbers
     */
    public int climbStairs(int n) {
        if (n < 1 || n > 45) return -1;
        if (n <= 2) return n;
        int[] c = new int[n];
        c[0] = 1;
        c[1] = 2;
        for (int i = 2; i < n; i++) {
            c[i] = c[i-1] + c[i-2];
        }
        return c[n-1];
    }
}
