package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 509. Fibonacci Number
 * https://leetcode.com/problems/fibonacci-number/
 * Difficulty : Easy
 * Related Topics : Math, Dynamic Programming, Recursion, Memoization
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence,
 * called the Fibonacci sequence, such that each number is the
 * sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 *
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 *
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 * Constraints:
 *
 * 0 <= n <= 30
 *
 * created by Cenk Canarslan on 2021-11-21
 */
public class FibonacciNumber {

    @Test
    public void testFibonacciNumber() {
        assertEquals(8, fib(6));
        assertEquals(13, fib(7));
        assertEquals(21, fib(8));
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
     * Memory Usage: 35.6 MB, less than 76.49% of Java online submissions for Fibonacci Number.
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n > 30) return -1;
        if (n == 0 || n == 1) return n;
        int[] memo = new int[n];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i-2] + memo[i-1];
        }

        return memo[n-2] + memo[n-1];
    }

    private int recursiveWithoutMemoization(int n) {
        if (n > 30) return -1;
        if (n == 0 || n == 1) return n;
        return recursiveWithoutMemoization(n-2) + recursiveWithoutMemoization(n-1);
    }
}
