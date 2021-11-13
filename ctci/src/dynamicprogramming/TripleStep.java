package dynamicprogramming;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * TripleStep
 * https://github.com/careercup/CtCI-6th-Edition/tree/master/Java/Ch%2008.%20Recursion%20and%20Dynamic%20Programming/Q8_01_Triple_Step
 * Difficulty : Easy
 * Related Topics : Recursion, Dynamic Programming
 *
 * created by Cenk Canarslan on 2021-11-14
 */
public class TripleStep {

    @Test
    public void testTripleStep() {
        int stepCount = 5;
        assertEquals(13, calculatePossibleWaysBruteForce(stepCount));
        assertEquals(13, calculatePossibleWaysTopDownDP(stepCount));
    }

    public static void main(String[] args) {
        TripleStep tripleStep = new TripleStep();
        int stepCount = 5;
        int possibleWays = tripleStep.calculatePossibleWaysBruteForce(stepCount);
        System.out.println("possibleWays = " + possibleWays);
        possibleWays = tripleStep.calculatePossibleWaysTopDownDP(stepCount);
        System.out.println("possibleWays = " + possibleWays);
    }

    private int calculatePossibleWaysTopDownDP(int stepCount) {
        int memo[] = new int[stepCount + 1];
        Arrays.fill(memo, -1);
        return calculatePossibleWaysTopDownDP(stepCount, memo);
    }

    private int calculatePossibleWaysTopDownDP(int stepCount, int[] memo) {
        if (stepCount < 0) {
            return 0;
        } else if (stepCount == 0) {
            return 1;
        } else if (memo[stepCount] > -1) {
            return memo[stepCount];
        } else {
            memo[stepCount] = calculatePossibleWaysTopDownDP(stepCount - 1, memo)
                    + calculatePossibleWaysTopDownDP(stepCount - 2, memo)
                    + calculatePossibleWaysTopDownDP(stepCount - 3, memo);
            return memo[stepCount];
        }
    }

    /**
     * time complexity = O(3^n)
     * @param stepCount
     * @return
     */
    private int calculatePossibleWaysBruteForce(int stepCount) {
        if (stepCount < 0) {
            return 0;
        } else if (stepCount == 0) {
            return 1;
        } else {
            return calculatePossibleWaysBruteForce(stepCount - 1)
                    + calculatePossibleWaysBruteForce(stepCount - 2)
                    + calculatePossibleWaysBruteForce(stepCount - 3);
        }
    }
}