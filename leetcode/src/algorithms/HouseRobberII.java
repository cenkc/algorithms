package algorithms;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * 213. House Robber II
 * https://leetcode.com/problems/house-robber-ii/
 * Difficulty : Medium
 * Related Topics : Array, Dynamic Programming
 *
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed. All houses at this place
 * are arranged in a circle. That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have a security system connected, and it will automatically
 * contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2)
 * and then rob house 3 (money = 2), because they are adjacent houses.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: 3
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 *
 * created by Cenk Canarslan on 2022-07-14
 */
public class HouseRobberII {

    @Test
    public void testHouseRobber() {
        assertEquals(3, rob(new int[]{2, 3, 2}));
        assertEquals(4, rob(new int[]{1, 2, 3, 1}));
        assertEquals(3, rob(new int[]{1, 2, 3}));
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(helper(nums, 0, len-2), helper(nums, 1, len-1));
    }

    public int helper(int[] nums, int begin, int end) {
        int len = end + 1;
        int[] dp = new int[len];

        dp[begin] = nums[begin];
        dp[begin + 1] = Math.max(nums[begin], nums[begin + 1]);

        for (int i = begin + 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[len-1];
    }
}
