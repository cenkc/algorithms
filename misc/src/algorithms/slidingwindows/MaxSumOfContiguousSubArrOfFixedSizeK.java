package algorithms.slidingwindows;

import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Maximum Sum Of Contiguous SubArray Of Fixed Size K
 * https://www.youtube.com/watch?v=MK-NZ4hN7rs&t=505s
 * Related Topics : Sliding Window
 *
 * created by Cenk Canarslan on 4/24/2020
 */
public class MaxSumOfContiguousSubArrOfFixedSizeK {

    public static int solution(int[] A, int K) {
        int max_val = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (i > K - 1) {
                sum -= A[i - K];
            }
            max_val = Math.max(sum, max_val);
        }
        return max_val;
    }

    public static void main (String[] args) {
        int[] A = new int[]{4, 2, 1, 7, 8, 1 ,2, 8, 1, 0};
        int K = 3;
        System.out.println(solution(A, K));

        assertEquals(16, solution(new int[]{4, 2, 1, 7, 8, 1 ,2, 8, 1, 0}, K));
    }
}
