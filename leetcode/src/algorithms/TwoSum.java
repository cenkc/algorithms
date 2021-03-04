package algorithms;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 * Difficulty : Medium
 * Related Topics : Array, HashTable
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 *
 * Hint 1 :
 * A really brute force way would be to search for all possible pairs of numbers but that would be too slow.
 * Again, it's best to try out brute force solutions for just for completeness.
 * It is from these brute force solutions that you can come up with optimizations.
 *
 * Hint 2 :
 * So, if we fix one of the numbers, say
 * x
 * , we have to scan the entire array to find the next number
 * y
 * which is
 * value - x
 * where value is the input parameter. Can we change our array somehow so that this search becomes faster?
 *
 * Hint 3 :
 * The second train of thought is, without changing the array, can we use additional space somehow?
 * Like maybe a hash map to speed up the search?
 *
 *
 * created by cenkc on 07.08.2020
 */
public class TwoSum {
    /**
     *
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *
     * <p>You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * <p><b>Example:</b>
     * <p>
     * <pre>{@code
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     * }</pre>
     *
     * @param nums array of integers
     * @param target target number
     * @return indices of the two numbers such that they add up to a specific target
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> bucket = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final int complement = target - nums[i];
            if (bucket.containsKey(complement)) {
                return new int[]{bucket.get(complement), i};
            }
            bucket.put(nums[i], i);
        }
        throw new IllegalArgumentException("no result");
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] expected = {0, 1};
        int[] arg1 = {2, 7, 11, 15};
        int arg2 = 9;
        assertArrayEquals(expected, twoSum.twoSum(arg1, arg2));
    }
}
