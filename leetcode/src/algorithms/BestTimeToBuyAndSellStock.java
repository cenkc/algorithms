package algorithms;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Difficulty : Easy
 * Related Topics : Array, Dynamic Programming
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 * created by Cenk Canarslan on 2021-01-17
 */
public class BestTimeToBuyAndSellStock {

    /**
     * O(n)
     * Runtime: 2 ms, faster than 29.62% of Java online submissions
     * Memory Usage: 52 MB, less than 5.47% of Java online submissions
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
        }
        return maxProfit;
    }

//    /**
//     * O(n)
//     * Runtime: 4 ms, faster than 20.04% of Java online submissions
//     * Memory Usage: 105.1 MB, less than 5.47% of Java online submissions
//     *
//     * @param prices
//     * @return
//     */
//    public int maxProfit(int[] prices) {
//        int lowestDay = 0;
//        int maxProfit = 0;
//
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[lowestDay] > prices[i]) {
//                lowestDay = i;
//            }
//            if (prices[i] - prices[lowestDay] > maxProfit) {
//                maxProfit = prices[i] - prices[lowestDay];
//            }
//        }
//        return maxProfit;
//    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTime = new BestTimeToBuyAndSellStock();
        System.out.println(bestTime.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println(bestTime.maxProfit(new int[]{7, 6, 4, 3, 1})); // 0
    }
}
