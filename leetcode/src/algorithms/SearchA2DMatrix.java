package algorithms;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 * Difficulty : Medium
 * Related Topics : Array, Binary Search, Matrix
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 *
 * Example 1:
 *   ---- ---- ---- ----
 *  |  1 |  3 |  5 |  7 |
 *   ---- ---- ---- ----
 *  | 10 | 11 | 16 | 20 |
 *   ---- ---- ---- ----
 *  | 23 | 30 | 34 | 60 |
 *   ---- ---- ---- ----
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * Example 2:
 *   ---- ---- ---- ----
 *  |  1 |  3 |  5 |  7 |
 *   ---- ---- ---- ----
 *  | 10 | 11 | 16 | 20 |
 *   ---- ---- ---- ----
 *  | 23 | 30 | 34 | 60 |
 *   ---- ---- ---- ----
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * created by Cenk Canarslan on 2021-11-08
 */
public class SearchA2DMatrix {

    @Test
    public void testSearchMatrix() {
        assertTrue(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        assertTrue(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 10));
        assertFalse(searchMatrix(new int[][]{{-8,-7},{-5,-5}}, 0));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int down = matrix.length - 1;
        int colLength = matrix[0].length - 1;

        while (top <= down) {
            // int mid = (top + down) / 2;
            int mid = top + (down - top) / 2;
            // e.g. matrix[0] = {1,3,5,7}, target=3, so 1 <= target <= 7
            if (matrix[mid][0] <= target && matrix[mid][colLength] >= target) {
                return searchCurrentRow(matrix[mid], target);
            }
            if (matrix[mid][colLength] < target) {
                top = mid + 1;
            }
            if (matrix[mid][0] > target) {
                down = mid - 1;
            }
        }
        return false;
    }

    private boolean searchCurrentRow(int[] currentRow, int target) {
        int left = 0;
        int right = currentRow.length - 1;

        while (left <= right) {
            // int mid = (left + right) / 2;
            int mid = left + (right - left) / 2;
            if (currentRow[mid] == target) {
                return true;
            }
            if (currentRow[mid] < target) {
                left = mid + 1;
            }
            if (currentRow[mid] > target){
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 130 / 133 test cases passed.
     * Fails on negative numbers, needed to be fixed
     *
     * @param matrix
     * @param target
     * @return
     */
    private boolean searchMatrixSolutionOne(int[][] matrix, int target) {
        int colLength = matrix.length;
        int rowLength = matrix[0].length;
        int[] arrPivot = new int[colLength];
        for (int i = 0; i < colLength; i++) {
            int rowPivot = matrix[i][rowLength - 1];
            if (rowPivot == target || matrix[i][0] == target) {
                return true;
            }
            arrPivot[i] = rowPivot;
        }
        System.out.println("arrPivot = " + Arrays.toString(arrPivot));
        int[] arrBS = new int[matrix[0].length];
        int i = 0;
        while(i < arrPivot.length) {
            if (target < arrPivot[i]) {
                arrBS = matrix[i];
                break;
            }
            i++;
        }
        System.out.println("Arrays.toString(arrBS) = " + Arrays.toString(arrBS));

        return searchBS(arrBS, target);
    }

    private boolean searchBS(int[] arrBS, int target) {

        int left = 0;
        int right = arrBS.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arrBS[mid] == target) {
                return true;
            }
            if (target > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    private boolean searchMatrixBruteForce(int[][] matrix, int target) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.println("row + \"-\" + col + \"-\" + matrix[row][col] = " + row + "-" + col + "-" + matrix[row][col]);
                if (matrix[row][col] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
