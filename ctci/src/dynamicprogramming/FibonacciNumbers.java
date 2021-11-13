package dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * created by Cenk Canarslan on 2021-11-13
 */
public class FibonacciNumbers {

    @Test
    public void testFibonacciNumbers() {
        /**
         * recursive
         */
        assertEquals(8, fibonacciWithoutMemo(6));
        /**
         * Top-Down Dynamic Programming (or Memoization)
         */
        assertEquals(13, fibonacciTopDownDP(7));
        /**
         * Bottom-Up Dynamic Programming
         */
        assertEquals(21, fibonacciBottomUpDP(8));
    }

    public static void main(String[] args) {
        FibonacciNumbers fib = new FibonacciNumbers();
        int i = 8;
//        int result = fib.fibonacciWithoutMemo(i);
//        int result = fib.fibonacciTopDownDP(i);
        int result = fib.fibonacciBottomUpDP(i);
        long end = System.currentTimeMillis();
        System.out.println("result = " + result);
    }

    private int fibonacciBottomUpDP(int n) {
        if (n == 0 || n == 1) return n;
        int[] memo = new int[n];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i-2] + memo[i-1];
        }

        return memo[n-2] + memo[n-1];
    }

    private int fibonacciTopDownDP(int n) {
        return fibonacciTopDownDP(n, new int[n + 1]);
    }

    private int fibonacciTopDownDP(int i, int[] memo) {
        if (i == 0 || i == 1) return i;
        if (memo[i] == 0) {
            memo[i] = fibonacciTopDownDP(i - 2, memo) + fibonacciTopDownDP(i - 1, memo);
        }
        return memo[i];
    }

    private int fibonacciWithoutMemo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacciWithoutMemo(n-2) + fibonacciWithoutMemo(n-1);
    }

}
