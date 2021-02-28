package lessons.arrays;

import java.util.Arrays;

/**
 * Cyclic Rotation
 * https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 * Difficulty : Easy
 * Related Topics : Arrays
 *
 * created by cenkc on 4/5/2020
 */
public class CyclicRotation {

    public static void main(String[] args) {
        int[] A = new int[]{5, 4, 3};
        int K = 2;

        CyclicRotation cyclicRotation = new CyclicRotation();
        final int[] solution = cyclicRotation.solution(A, K);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int[] A, int K) {
        //wrapping array to securely get a valid index
        //https://cs50.stackexchange.com/a/1376
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int shiftedIndex = (i + K) % A.length;
            B[shiftedIndex] = A[i];
        }
        return B;
    }
}
