package algorithms.study;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 0/1 KnapsackZeroOne
 * https://www.youtube.com/watch?v=zRza99HPvkQ&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O&index=55
 * Difficulty : Medium
 * Related Topics : Dynamic Programming
 *
 * created by Cenk Canarslan on 2021-11-19
 */
public class KnapsackZeroOne {

    @Test
    public void testKnapsackZeroOne() {
        // knapsack(int[] profit, int[] weight, int knapsackCapacity)
        assertEquals(8, knapsack(new int[]{1, 2, 5, 6}, new int[]{2, 3, 4, 5}, 8));
        assertEquals(8, knapsack(new int[]{2, 2, 5, 6}, new int[]{1, 2, 3, 4}, 5));
        assertEquals(9, knapsack(new int[]{1, 4, 5, 7}, new int[]{1, 3, 4, 5}, 7));
        assertEquals(7, knapsack(new int[]{2, 3, 5}, new int[]{1, 2, 3}, 4));
        assertEquals(220, knapsack(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));
    }

    public static void main(String[] args) {

        int[] profit = {1,2,5,6};
        int[] weight = {2,3,4,5};
        int knapsackCapacity = 8;

        KnapsackZeroOne knapsack = new KnapsackZeroOne();
        int k = knapsack.knapsack(profit, weight, knapsackCapacity);
        System.out.println("knapsack = " + k);
    }

    /**
     * Time Complexity = O(n.w) (n->number of items, w->capacity)
     *
     * @param profit
     * @param weight
     * @param knapsackCapacity
     * @return
     */
    private int knapsack(int[] profit, int[] weight, int knapsackCapacity) {
        if (profit.length != weight.length) return -1;
        int[][] dp = new int[profit.length + 1][knapsackCapacity + 1];

        for (int i = 0; i <= profit.length; i++) {
            for (int w = 0; w <= knapsackCapacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weight[i-1] <= w) {
                    dp[i][w] = Math.max(profit[i-1] + dp[i-1][w-weight[i-1]], dp[i-1][w]);
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        printMatrix(dp);
        return dp[profit.length][knapsackCapacity];
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.println("matrix["+i+"]["+j+"] = " + matrix[i][j]);
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
