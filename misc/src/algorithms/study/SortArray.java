package algorithms.study;

/**
 * created by cenkc on 5/10/2021
 */
public class SortArray {

    public static void main(String[] args) {
        SortArray sa = new SortArray();
        int[] arr = {3,8,11,4,7,22,16,18};
        int[] sortedArr = sa.selectionSort(arr);
        sa.printArray(sortedArr);
    }

    private int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    private static void printArray(int[] sortedArr) {
        for (int i = 0; i < sortedArr.length; i++) {
            System.out.println("sortedArr[i] = " + sortedArr[i]);
        }
    }
}
