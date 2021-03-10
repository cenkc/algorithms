package algorithms.sorting;

import java.util.Arrays;

/**
 * created by Cenk Canarslan on 2021-02-04
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{20, 35, -15, 7, 55, 1, -22};
//        int[] arr = new int[]{5, 6, 7, 2, 4, 1, 7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        System.out.println("sorted arr = " + Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            sort(arr, begin, mid);
            sort(arr, mid + 1, end);
            merge(arr, begin, mid, end);
        }
    }

    private void merge(int[] arr, int begin, int mid, int end) {
        // create temp arrays
        int[] leftArray = new int[mid - begin + 1];
        int[] rightArray = new int[end - mid];
        // copy sub arrays into temp arrays
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arr[begin + i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = arr[mid + i + 1];
        }

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = begin; i < end + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    arr[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    arr[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                arr[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                arr[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}
