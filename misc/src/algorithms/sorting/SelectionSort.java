package algorithms.sorting;

import java.util.Arrays;

/**
 * created by Cenk Canarslan on 2021-01-31
 */
public class SelectionSort {

    /**
     * Time Complexity :
     * - Worst   : O(n^2)
     * - Average : O(n^2)
     * - Best    : O(n^2)
     *
     * Space Complexity :
     * O(1)
     *
     * @param arr
     */
    private void sort(int[] arr) {
        System.out.println("initial:" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
                System.out.println("(i=" + i + ",j=" + j + ")-[" + arr[j] + ":" + arr[minPos] + "]");
            }
            int tmp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = tmp;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{64, 34, 25, 12, 22, 11, 90, 12};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        System.out.println("sorted:" + Arrays.toString(arr));
    }
}
