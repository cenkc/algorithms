package algorithms.slidingwindows;

/**
 * Smallest subarray with given sum
 * https://www.youtube.com/watch?v=MK-NZ4hN7rs&t=1490s
 * Related Topics : Sliding Window
 *
 * created by cenkc on 4/24/2020
 */
public class SmallestSubArrWithGivenSum {

    public static void main (String[] args) {
        int[] A = new int[]{4, 2, 1, 7, 8, 1 ,2, 8, 1, 0};
        int K = 8;
        SmallestSubArrWithGivenSum smallestSubArrWithGivenSum = new SmallestSubArrWithGivenSum();
        System.out.println(smallestSubArrWithGivenSum.solution(A, K));
    }

    public int solution(int[] A, int K) {
        int minWindowSize = Integer.MAX_VALUE;
        int sumOfWindow = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < A.length; windowEnd++) {
            sumOfWindow += A[windowEnd];
            while (sumOfWindow >= K) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                sumOfWindow -= A[windowStart];
                windowStart++;
            }
        }
        return minWindowSize;
    }
}
