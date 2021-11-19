package algorithms.study;

/**
 * 0/1 KnapsackZeroOne
 * https://www.youtube.com/watch?v=zRza99HPvkQ&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O&index=55
 * Difficulty : Medium
 * Related Topics : Dynamic Programming
 *
 * created by Cenk Canarslan on 2021-11-19
 */
public class KnapsackZeroOne {

    public static void main(String[] args) {

        int[] profit = {1,2,5,6};
        int[] weight = {2,3,4,5};
        int knapsackCapacity = 8;

        KnapsackZeroOne knapsack = new KnapsackZeroOne();
        int k = knapsack.knapsack(profit, weight, knapsackCapacity);
        System.out.println("knapsack = " + k);
    }

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
