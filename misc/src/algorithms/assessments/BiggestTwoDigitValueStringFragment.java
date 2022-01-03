package algorithms.assessments;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

/**
 * https://gist.github.com/cenkc/9a9155da530de5c1c898446f29e5d643
 *
 * created by Cenk Canarslan on 2021-07-12
 */
public class BiggestTwoDigitValueStringFragment {

    @Test
    public void testBiggestTwoDigit() {
        assertEquals(55, solution("50552"));
        assertEquals(10, solution("10101"));
        assertEquals(88, solution("88"));
        assertEquals(-1, solution("1"));
        assertEquals(-1, solution("01"));
        assertEquals(-1, solution("123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789011")); //len 102
    }

    public int solution(String S) {
        if (S.length() < 2 || S.length() > 100
                || S.charAt(0) == '0') {
            return -1;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < S.length() - 1; i++) {
            if ( ! Character.isDigit(S.charAt(i)) || ! Character.isDigit(S.charAt(i + 1))) {
                return -1;
            }
            result = Math.max(Integer.parseInt(S.substring(i, i + 2)), result);
        }
        return result;
    }

    /**
     * Naive solution with PriorityQueue (max)
     * @param S
     * @return
     */
    public int solution2(String S) {

        if (S.length() < 2 || S.length() > 100 || S.charAt(0) == '0') return -1;

//        Comparator<Integer> comp = Collections.reverseOrder();
//        PriorityQueue<Integer> pq = new PriorityQueue<>(comp);

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o2 > o1) return 1;
                if (o1 > o2) return -1;
                return 0;
            }
        });

        for (int i = 0; i < S.length() - 1; i++) {
            pq.add(Integer.valueOf(S.substring(i, i+2)));
        }
        return pq.peek();
    }

}
