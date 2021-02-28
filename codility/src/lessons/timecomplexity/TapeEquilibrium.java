package lessons.timecomplexity;

/**
 * Tape Equilibrium (TapeEquilibrium)
 * https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 * Difficulty : Easy
 * Related Topics : Time Complexity
 *
 * created by cenkc on 4/5/2020
 */
public class TapeEquilibrium {

    public static void main(String[] args) {
        int[] A = new int[]{3, 1, 2, 4 ,3};
        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        System.out.println(tapeEquilibrium.solution(A));
    }

    public int solution(int[] A) {
        long sumOfArray = getSumOfArray(A);

        int minDiffValue = Integer.MAX_VALUE;
        int currDiffValue = Integer.MAX_VALUE;
        long sum1stPart = 0;
        long sum2ndPart = 0;
        for (int j = 0; j < A.length - 1; j++) {
            sum1stPart += A[j];
            sum2ndPart = sumOfArray - sum1stPart;
            currDiffValue = (int) Math.abs(sum1stPart - sum2ndPart);
            minDiffValue = Math.min(currDiffValue, minDiffValue);
        }
        return minDiffValue;
    }

    private long getSumOfArray(int[] A) {
        long sumOfArray = 0;
        for (int i = 0; i < A.length; i++) {
            sumOfArray += A[i];
        }
        return sumOfArray;
    }

}
