package lessons.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Odd Occurrences In Array
 * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 * Difficulty : Easy
 * Related Topics : Arrays
 *
 * created by cenkc on 4/5/2020
 */
public class OddOccurrencesInArray {

    public static void main(String[] args) {
        int[] A = new int[]{9, 3, 9, 3, 9, 7, 9};

        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        final int solution = oddOccurrencesInArray.solution(A);
        System.out.println(solution);
    }

    public int solution(int[] A) {
        Map<Integer, Integer> bucket = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (bucket.containsKey(A[i])) {
                int count = bucket.get(A[i]);
                count++;
                bucket.put(A[i], count);
            } else {
                bucket.put(A[i], 1);
            }
        }
        for (Integer key : bucket.keySet()) {
            if (bucket.get(key) % 2 != 0) {
                return key;
            }
        }
        return 0;
    }

}
