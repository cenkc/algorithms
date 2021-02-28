package lessons.timecomplexity;

import java.util.HashSet;
import java.util.Set;

/**
 * Permutation Missing Element (PermMissingElem)
 * https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 * Difficulty : Easy
 * Related Topics : Time Complexity
 *
 * created by cenkc on 4/5/2020
 */
public class PermMissingElem {

    public static void main(String[] args) {
        int[] A = new int[]{2, 3, 1, 5};
        PermMissingElem permMissingElem = new PermMissingElem();
        System.out.println(permMissingElem.solution(A));
    }

    public int solution(int[] A) {
        Set incomplete = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            incomplete.add(A[i]);
        }

        for (int i = 1; i <= A.length + 1; i++) {
            if (!incomplete.contains(i)) {
                return i;
            }
        }
        throw new RuntimeException("exception");
    }

/*
    // score below 80%
    public int solution(int[] A) {
        final int n = A.length + 1; // item count of complete array
        final int completeArraySum = (n * (n +1 ))/2;
        return (completeArraySum - getSumOfArray(A));
    }

    private int getSumOfArray(int[] A) {
        int r = 0;
        for (int i = 0; i < A.length; i++) {
            r += A[i];
        }
        return r;
    }
*/
}
