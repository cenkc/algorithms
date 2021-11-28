package algorithms;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * Difficulty : Medium
 * Related Topics : Array, Binary Search, Dynamic Programming
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some
 * or no elements without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 *
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 * Constraints:
 *
 *     1 <= nums.length <= 2500
 *     -104 <= nums[i] <= 104
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 *
 * created by Cenk Canarslan on 2021-11-24
 */
public class LongestIncreasingSubsequence {

    @Test
    public void testLongestIncreasingSubsequence() {
        assertEquals(4, lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        assertEquals(4, lengthOfLIS(new int[]{0,1,0,3,2,3}));
        assertEquals(1, lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        assertEquals(3, lengthOfLIS(new int[]{1,2,4,3}));
    }

    /**
     * Dynamic Programming solution with O(n^2) Time Complexity
     *
     * Runtime: 73 ms, faster than 26.15% of Java online submissions for Longest Increasing Subsequence.
     * Memory Usage: 39.3 MB, less than 35.85% of Java online submissions for Longest Increasing Subsequence.
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {

        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);

        int max = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
//                System.out.println("i,j = " + i + "," + j + ",\t nums[i] = " + nums[i] + ", nums[j]" + nums[j]);
                if (nums[i] < nums[j]) {
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                    max = Math.max(max, lis[i]);
                }
            }
        }

//        int max = 0;
//        for (int k = 0; k < lis.length; k++) {
//            if (lis[k] > max) {
//                max = lis[k];
//            }
//        }
        System.out.println("lis = " + Arrays.toString(lis) + ", max of lis = " + max);

        return max;
    }
}

