package algorithms;

import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 * 704. Binary Search
 * https://leetcode.com/problems/binary-search/
 * Difficulty : Easy
 * Related Topics : Array, BinarySearch
 *
 * Given an array of integers nums which is sorted in ascending order,
 * and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 < nums[i], target < 104
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 *
 *
 * created by Cenk Canarslan on 2021-10-21
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        assertEquals(4, bs.search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(1, bs.search(new int[] {2, 5}, 5));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target > mid) {
                left = mid + 1;
            }
            if (target < mid) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
