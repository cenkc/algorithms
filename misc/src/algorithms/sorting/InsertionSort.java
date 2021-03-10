package algorithms.sorting;

import java.util.Arrays;

/**
 * created by Cenk Canarslan on 2021-02-01
 */
public class InsertionSort {

    /**
     * Time Complexity :
     * - Worst   : O(n^2)
     * - Average : O(n^2)
     * - Best    : O(n)
     *
     * Space Complexity :
     * O(1)
     *
     * @param arr
     */
    private void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > key; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = key;
        }
    }

    /**
     * Alternative implementation
     *
     * @param arr
     */
    private void sort2(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort2(arr);
        System.out.println(Arrays.toString(arr));
    }


















}