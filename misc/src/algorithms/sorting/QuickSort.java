package algorithms.sorting;

import java.util.Arrays;

/**
 * created by Cenk Canarslan on 2021-12-05
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
//        int[] arr = new int[]{20, 35, -15, 7, 55, 1, -22};
        int[] arr = new int[] {15, 3, 2, 1, 9, 5, 7, 8, 6};
        quickSort.qs(arr, 0, arr.length - 1);
        System.out.println("Quick Sort = " + Arrays.toString(arr));
    }

    /**
     * Time Complexity :
     * - Worst   : O(n^2), when the array is in reverse order
     * - Average : O(n^2), when the array is already sorted
     * - Best    : O(n)
     *
     * Space Complexity :
     * O(1)
     *
     * @param arr
     * @param left
     * @param right
     */
    public void qs(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = arr[(left + right) / 2];
        int index = partition(arr, left, right, pivot);
        qs(arr, left, index - 1);
        qs(arr, index, right);
    }

    public int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

}
