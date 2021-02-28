package lessons.iterations;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Binary Gap
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 * Difficulty : Easy
 * Related Topics : Iterations
 *
 * created by cenkc on 4/4/2020
 */
public class BinaryGap {

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        assertEquals(0, binaryGap.solution(32));
        assertEquals(2, binaryGap.solution(9));
        assertEquals(4, binaryGap.solution(529));
        assertEquals(1, binaryGap.solution(20));
        assertEquals(0, binaryGap.solution(15));
    }

    public int solution(int N) {
        final String binaryString = Integer.toBinaryString(N);
        System.out.println("binaryString = " + binaryString);
        if (! binaryString.contains("1")) {
            System.out.println("Binary string representation of 'N' has no 1's in it, so there's no binary gap(s)");
            return 0;
        }

        final int lastIndex = binaryString.lastIndexOf("1");

        final String str2BeProcessed = binaryString.substring(0, lastIndex);
        System.out.println("str2BeProcessed = " + str2BeProcessed);

        final String[] split = str2BeProcessed.split("1"); //

        if (split.length == 0) {
            System.out.println("No binary gap(s)");
            return 0;
        } else {
            System.out.println("split = " + Arrays.asList(split).toString());
            return doTheWork(split);
        }
    }

    private int doTheWork(String[] split) {
        int result = 0;
        int x = 0;

        while(x < split.length) {
            result = result > split[x].length() ? result : split[x].length();
            x++;
        }
        return result;
    }
}
