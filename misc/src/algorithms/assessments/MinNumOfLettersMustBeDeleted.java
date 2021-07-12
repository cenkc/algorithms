package algorithms.assessments;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://gist.github.com/cenkc/9a9155da530de5c1c898446f29e5d643
 *
 * created by Cenk Canarslan on 2021-07-12
 */
public class MinNumOfLettersMustBeDeleted {

    public static void main(String[] args) {
        MinNumOfLettersMustBeDeleted mnol = new MinNumOfLettersMustBeDeleted();
//        String str = "aaaabbbb"; // 1
        // TODO solution is not covering case "ccaaffddecee", fix it
        String str = "ccaaffddecee"; // expecting 6, returns 3 ?????
//        String str = "eeee"; // 0
//        String str = "example"; // 4

        int solution = mnol.solution(str);
        System.out.println("solution = " + solution);
    }

    public int solution(String S) {
        if (S.length() < 0 || S.length() > 300000) {
            return -1;
        }
        S = S.toLowerCase();
        Map<Character, Integer> charMap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;

        // initialize charMap with char occurrences
        for (int i = 0; i < S.length(); i++) {
            char charKey = S.charAt(i);
            if ( ! Character.isLowerCase(charKey)) {
                return -1;
            }
            charMap.put(charKey, charMap.getOrDefault(charKey, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            pq.add(entry.getValue());
        }

        while ( ! pq.isEmpty()) {
            Integer highest = pq.peek();
            pq.poll();
            if (pq.isEmpty()) {
                return result;
            }
            if (highest == pq.peek()) {
                if (highest > 1) {
                    pq.add(highest - 1);
                }
                result++;
            }
        }
        return result;
    }
}
