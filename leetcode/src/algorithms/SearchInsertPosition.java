package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 * Difficulty : Easy
 * Related Topics : Array, BinarySearch
 *
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 * Example 4:
 *
 * Input: nums = [1,3,5,6], target = 0
 * Output: 0
 *
 * Example 5:
 *
 * Input: nums = [1], target = 0
 * Output: 0
 *
 * Constraints:
 *
 *     1 <= nums.length <= 104
 *     -104 <= nums[i] <= 104
 *     nums contains distinct values sorted in ascending order.
 *     -104 <= target <= 104
 *
 * created by Cenk Canarslan on 2021-10-22
 */
public class SearchInsertPosition {

    @Test
    public void check() {
        SearchInsertPosition sip = new SearchInsertPosition();
        assertEquals(2, sip.searchInsert(new int[] {1, 3, 5, 6}, 5));
        assertEquals(1, sip.searchInsert(new int[] {1, 3, 5, 6}, 2));
        assertEquals(4, sip.searchInsert(new int[] {1, 3, 5, 6}, 7));
        assertEquals(0, sip.searchInsert(new int[] {1, 3, 5, 6}, 0));
        assertEquals(0, sip.searchInsert(new int[] {1}, 0));
    }

    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        int result = sip.searchInsert(new int[]{1, 3, 5, 6}, 5);
        System.out.println("result = " + result);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }
}

