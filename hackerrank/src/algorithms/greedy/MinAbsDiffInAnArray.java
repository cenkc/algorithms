package algorithms.greedy;

import org.junit.Assert;

import java.util.Arrays;

/**
 * Minimum Absolute Difference in an Array
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
 * Difficulty : Easy
 * Related Topics : Greedy Algorithms
 *
 * created by Cenk Canarslan on 2021-01-10
 */
public class MinAbsDiffInAnArray {

    static int minimumAbsoluteDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, Math.abs(arr[i] - arr[i - 1]));
        }
        return min;
    }

    public static void main(String[] args) {
        /**
         * Sample Input 0
         *   3
         *   3 -7 0
         * Sample Output 0
         *   3
         * Explanation 0
         *   The first line of input is the number of array elements.
         *   The array, arr = [3,-7,0] There are three pairs to test: (3,-7), (3,0), and (-7,0).
         *   The absolute differences are:
         *   * |3 - -7| = 10
         *   * |3 - 0| = 3
         *   * |-7 - 0| = 7
         *
         *   Remember that the order of values in the subtraction does not influence the result.
         *   The smallest of these absolute differences is 3.
         */
//        int[] arr = {3, -7, 0};
//        int result = minimumAbsoluteDifference(arr);
//        Assert.assertEquals(3, result);

        /**
         * Sample Input 1
         *   10
         *   -59 -36 -13 1 -53 -92 -2 -96 -54 75
         * Sample Output 1
         *   1
         * Explanation 1
         *   The minimum absolute difference is |-54 - -53| = 1
         */
        int[] arr = {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};
        int result = minimumAbsoluteDifference(arr);
        Assert.assertEquals(1, result);

        /**
         * Sample Input 2
         *   5
         *   1 -3 71 68 17
         * Sample Output 2
         *   3
         * Explanation 2
         *   The minimum absolute difference is |71 - 68| = 3
         */
//        int[] arr = {1, -3, 71, 68, 17};
//        int result = minimumAbsoluteDifference(arr);
//        Assert.assertEquals(3, result);

        System.out.println("Success!.. result is:" + result);
    }
}
