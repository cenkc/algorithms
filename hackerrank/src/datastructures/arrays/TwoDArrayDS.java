package datastructures.arrays;

import org.junit.Assert;

/**
 * Minimum Absolute Difference in an Array
 * https://www.hackerrank.com/challenges/2d-array/problem
 * Difficulty : Easy
 * Related Topics : Arrays
 *
 * https://www.hackerrank.com/domains/data-structures/arrays
 *
 * created by Cenk Canarslan on 2021-01-10
 */
public class TwoDArrayDS {
    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i <= arr.length-3 && j <= arr[i].length - 3) {
                    int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2]
                                        + arr[i+1][j+1]
                            + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}};

        int result = hourglassSum(arr);
        Assert.assertEquals(19, result);
    }
}
