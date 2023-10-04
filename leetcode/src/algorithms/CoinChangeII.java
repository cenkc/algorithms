package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 518. Coin Change II
 * https://leetcode.com/problems/coin-change-ii/description/
 * Difficulty : Medium
 * Related Topics : Array, Dynamic Programming
 *
 * You are given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money.
 *
 * Return the number of combinations that make up that amount. If that amount of money
 * cannot be made up by any combination of the coins, return 0.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * The answer is guaranteed to fit into a signed 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * All the values of coins are unique.
 * 0 <= amount <= 5000
 *
 * created by cenk on 2023-10-04
 */
public class CoinChangeII {

    @Test
    public void testCoinChangeII() {
        assertEquals(4, change(5, new int[]{1, 2, 5}));
        assertEquals(0, change(3, new int[]{2}));
        assertEquals(1, change(10, new int[]{10}));
        /**
         * common coins in US currency:
         * quarters (25 cents)
         * dimes (10 cents)
         * nickels (5 cents)
         * pennies (1 cent)
         */
        assertEquals(6, change(15, new int[]{1, 5, 10, 25})); // $0.15 (15 cents) = 6 ways
        assertEquals(242, change(100, new int[]{1, 5, 10, 25})); // $1.00 (100 cents) = 242 ways
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // There is one way to make change for zero cents (no coins)

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

}
