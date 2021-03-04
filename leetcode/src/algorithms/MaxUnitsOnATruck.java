package algorithms;

import java.util.Arrays;

/**
 * 1710. Maximum Units on a Truck
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 * Difficulty : Easy
 * Related Topics : Greedy, Sort
 *
 * You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 *
 * numberOfBoxesi is the number of boxes of type i.
 * numberOfUnitsPerBoxi is the number of units in each box of the type i.
 * You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
 *
 * Return the maximum total number of units that can be put on the truck.
 *
 *
 *
 * Example 1:
 *
 * Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * Output: 8
 * Explanation: There are:
 * - 1 box of the first type that contains 3 units.
 * - 2 boxes of the second type that contain 2 units each.
 * - 3 boxes of the third type that contain 1 unit each.
 * You can take all the boxes of the first and second types, and one box of the third type.
 * The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
 * Example 2:
 *
 * Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * Output: 91
 *
 *
 * Constraints:
 *
 * 1 <= boxTypes.length <= 1000
 * 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
 * 1 <= truckSize <= 106
 *
 * created by Cenk Canarslan on 2021-01-19
 */
public class MaxUnitsOnATruck {

    /**
     * Time Complexity : O(nlogn) -> Arrays.sort
     * Space Complexity : O(1)
     * Runtime: 7 ms, faster than 95.51% of Java online submissions
     * Memory Usage: 39 MB, less than 86.66% of Java online submissions
     *
     * @param boxTypes
     * @param truckSize
     * @return
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int countOfBoxes = 0;
        int index = 0;

        while (true) {
            int boxesToLoad = Math.min(truckSize, boxTypes[index][0]);
            countOfBoxes += boxesToLoad * boxTypes[index][1];
            truckSize -= boxesToLoad;
            index++;
            if (truckSize == 0) {
                break;
            }
            if (index == boxTypes.length) {
                break;
            }
        }
        return countOfBoxes;
    }

    public static void main(String[] args) {
        MaxUnitsOnATruck solution = new MaxUnitsOnATruck();
        System.out.println(solution.maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4)); // 8
        System.out.println(solution.maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10)); // 91
    }
}
