package algorithms.sorting;

import java.util.Arrays;

/**
 * created by Cenk Canarslan on 2021-01-30
 */
public class BubbleSort {

    /**
     * Time Complexity :
     * - Worst   : O(n^2), when the array is in reverse order
     * - Average : O(n^2), when the array is already sorted
     * - Best    : O(n^2)
     *
     * Space Complexity :
     * O(1)
     *
     * @param arr
     */
    private void sort(int[] arr) {
        System.out.println("          initial:" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                System.out.print("(i=" + i + ",j=" + j + ")-[" + arr[j] + ":" + arr[j+1] + "]");
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
                System.out.println("-"+Arrays.toString(arr));
            }
        }
    }

    private void sort2(int[] arr) {
        System.out.println("          initial:" + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr.length - 2 - i; j++) {
                if (arr[j+1] < arr[j]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
                System.out.println("-"+Arrays.toString(arr));
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{64, 34, 25, 12, 22, 11, 90, 12};
//        int[] arr = new int[]{7,2,6,1,3};
//        int[] arr = new int[]{5,1,6,1,3};

        BubbleSort bubbleSort = new BubbleSort();

        bubbleSort.sort(arr);
        System.out.println("           sorted:" + Arrays.toString(arr));
    }
}
