package algorithms;

/**
 * 746. Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 * Difficulty : Easy
 * Related Topics : Array, Dynamic Programming
 *
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 *
 * Once you pay the cost, you can either climb one or two steps.
 * You need to find minimum cost to reach the top of the floor,
 * and you can either start from the step with index 0, or the step with index 1.
 *
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 *
 *
 * created by Cenk Canarslan on 2021-02-07
 */
public class MinCostClimbingStairs {

    /**
     *
     * 					    	   __________
     * 				          ___ | Last step
     *                  ___ | 20
     *             ___ | 15
     * _________ | 10
     * First step
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] cost = new int[]{10, 15, 20}; // 15
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}; // 6

        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();

        int result = minCostClimbingStairs.minCostClimbingStairs(cost);
        System.out.println("minCostClimbingStairs = " + result);

        result = minCostClimbingStairs.minCostClimbingStairsOptimized(cost);
        System.out.println("minCostClimbingStairsOptimized = " + result);
    }

    /**
     * Dynamic Programming
     * Time Complexity : O(n)
     * Space Complexity : O(n) (not-in-place, because we're using an auxiliary DS)
     *
     * Runtime: 1 ms, faster than 78.71% of Java online submissions
     * Memory Usage: 38.5 MB, less than 79.84% of Java online submissions
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] aux = new int[cost.length + 1];
        // no need to assign 0, int array filled with 0s initially
//        aux[0] = 0;
//        aux[1] = 0;

        for (int i = 2; i < cost.length + 1; i++) {
            aux[i] = Math.min(
                    aux[i-2] + cost[i-2],
                    aux[i-1] + cost[i-1]);
        }
        return aux[cost.length];
    }

    /**
     * Optimized solution
     *
     * Dynamic Programming
     * Time Complexity : O(n)
     * Space Complexity : O(1) (in-place, because we're NOT using an auxiliary DS)
     *
     * Runtime: 1 ms, faster than 78.71% of Java online submissions
     * Memory Usage: 38.5 MB, less than 88.75% of Java online submissions
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairsOptimized(int[] cost) {
        int first = 0;
        int second = 0;
//        System.out.println("1st\t2nd\tc[i-2]\tc[i-1]");
        for (int i = 2; i < cost.length + 1; i++) {
            int tmp = Math.min(
                    first + cost[i-2],
                    second + cost[i-1]);
            first = second;
            second = tmp;
//            System.out.println(first + "\t" + second + "\t" + cost[i-2] + "\t" + cost[i-1]);
        }
        return second;
    }
}
