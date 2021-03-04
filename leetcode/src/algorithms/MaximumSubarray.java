package algorithms;

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 * Difficulty : Easy
 * Related Topics : Array, Divide and Conquer, Dynamic Programming
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [0]
 * Output: 0
 * Example 4:
 *
 * Input: nums = [-1]
 * Output: -1
 * Example 5:
 *
 * Input: nums = [-100000]
 * Output: -100000
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -10^5 <= nums[i] <= 10^5
 *
 *
 * Follow up: If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * created by Cenk Canarslan on 2021-01-20
 */
public class MaximumSubarray {

//    /**
//     * O(n)
//     * Runtime: 1 ms, faster than 51.00% of Java online submissions
//     * Memory Usage: 39.2 MB, less than 24.26% of Java online submissions
//     *
//     * NOTE = Watch for the preSum & finalSum initial values.
//     *        Integer.MIN_VALUE is not suitable.
//     *        Check https://github.com/cenkc/leetcode-studies/wiki/Notes#integermax_value-and-integermin_value-usages
//     *
//     * @param nums
//     * @return
//     */
//    public int maxSubArray(int[] nums) {
//        int preSum = -100000; // -10^5 <= nums[i] <= 10^5
//        int finalSum = -100000; // -10^5 <= nums[i] <= 10^5
//
//        for(int i = 0; i<nums.length; i++){
//            preSum = Math.max(preSum + nums[i], nums[i]);
//            finalSum = Math.max(finalSum, preSum);
//        }
//        return finalSum;
//    }

    /**
     * O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions
     * Memory Usage: 38.8 MB, less than 83.00% of Java online submissions
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int preSum = nums[0];
        int finalSum = nums[0];

        for(int i = 1; i<nums.length; i++){
            preSum = Math.max(preSum + nums[i], nums[i]);
            finalSum = Math.max(finalSum, preSum);
        }
        return finalSum;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(solution.maxSubArray(new int[]{1})); // 1
        System.out.println(solution.maxSubArray(new int[]{0})); // 0
        System.out.println(solution.maxSubArray(new int[]{-1})); // -1
        System.out.println(solution.maxSubArray(new int[]{-100000})); // -100000
    }
}
