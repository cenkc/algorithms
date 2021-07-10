package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 * Difficulty : Easy
 * Related Topics : Array, Dynamic Programming
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *     1
 *    1 1
 *   1 2 1
 *  1 3 3 1
 * 1 4 6 4 1
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 *
 * Constraints:
 *
 * 1 <= numRows <= 30
 *
 * created by Cenk Canarslan on 2021-06-27
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle();
        List<List<Integer>> triangle = pt.generate(1);
        printTriangle(triangle);
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1 || numRows > 30) {
            return null;
        }
        List<List<Integer>> mainList = new ArrayList<>();
        mainList.add(new ArrayList<>());
        mainList.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> currentList = new ArrayList<>();
            List<Integer> previousList = mainList.get(i - 1);
            currentList.add(1);
            for (int j = 1; j < i ; j++) {
                currentList.add(previousList.get(j-1) + previousList.get(j));
            }
            currentList.add(1);
            mainList.add(currentList);
        }
        return mainList;
    }

    private static void printTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            for (int i = 0; i < row.size(); i++) {
                System.out.print(row.get(i) + " ");
            }
            System.out.println("");
        }
    }
}
