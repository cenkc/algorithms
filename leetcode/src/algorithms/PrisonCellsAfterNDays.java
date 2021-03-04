package algorithms;

import java.util.Arrays;

/**
 * 957. Prison Cells After N Days
 * https://leetcode.com/problems/prison-cells-after-n-days/
 * Difficulty : Medium
 * Related Topics : Hash Table
 *
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.
 *
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 *
 * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 * Otherwise, it becomes vacant.
 * (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
 *
 * We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
 *
 * Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
 *
 *
 *
 * Example 1:
 *
 * Input: cells = [0,1,0,1,1,0,0,1], N = 7
 * Output: [0,0,1,1,0,0,0,0]
 * Explanation:
 * The following table summarizes the state of the prison on each day:
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 *
 * Example 2:
 *
 * Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
 * Output: [0,0,1,1,1,1,1,0]
 *
 *
 * Note:
 *
 * cells.length == 8
 * cells[i] is in {0, 1}
 * 1 <= N <= 10^9
 *
 * created by cenkc on 8/11/2020
 */
public class PrisonCellsAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int N) {
        //int cycleDay = ((N-1)%14)+1;
        int[] result = new int[cells.length];
        for(int day = 0; day < N; day++) {
            for (int i = 1; i < cells.length - 1; i++) {
                if (cells[i-1] == cells[i+1]) {
                    result[i] = 0;
                } else {
                    result[i] = 1;
                }
            }
            //System.arraycopy(result, 0, cells, 0, cells.length);
            cells = Arrays.copyOf(result, cells.length);
        }
        return cells;
    }

    public static void main(String[] args) {
//        int N = 7;
//        int[] cells = new int[]{0,1,0,1,1,0,0,1};
        int N = 2;
        int[] cells = new int[]{1,1,1,0,1,1,1,1};
        System.out.println("init\t" + Arrays.toString(cells));
        PrisonCellsAfterNDays cellsAfterNDays = new PrisonCellsAfterNDays();
        final int[] later = cellsAfterNDays.prisonAfterNDays(cells, N);
        System.out.println("last\t" + Arrays.toString(later));

        /**
         *
         * following output can show the pattern
         *
         * init	    [0, 1, 0, 1, 1, 0, 0, 1]
         * 0		[0, 1, 1, 0, 0, 0, 0, 0] *
         * 1		[0, 0, 0, 0, 1, 1, 1, 0]
         * 2		[0, 1, 1, 0, 0, 1, 0, 0]
         * 3		[0, 0, 0, 0, 0, 1, 0, 0]
         * 4		[0, 1, 1, 1, 0, 1, 0, 0]
         * 5		[0, 0, 1, 0, 1, 1, 0, 0]
         * 6		[0, 0, 1, 1, 0, 0, 0, 0]
         * 7		[0, 0, 0, 0, 0, 1, 1, 0]
         * 8		[0, 1, 1, 1, 0, 0, 0, 0]
         * 9		[0, 0, 1, 0, 0, 1, 1, 0]
         * 10		[0, 0, 1, 0, 0, 0, 0, 0]
         * 11		[0, 0, 1, 0, 1, 1, 1, 0]
         * 12		[0, 0, 1, 1, 0, 1, 0, 0]
         * 13		[0, 0, 0, 0, 1, 1, 0, 0]
         * 14		[0, 1, 1, 0, 0, 0, 0, 0] *
         * 15		[0, 0, 0, 0, 1, 1, 1, 0]
         * 16		[0, 1, 1, 0, 0, 1, 0, 0]
         * 17		[0, 0, 0, 0, 0, 1, 0, 0]
         * 18		[0, 1, 1, 1, 0, 1, 0, 0]
         * 19		[0, 0, 1, 0, 1, 1, 0, 0]
         * 20		[0, 0, 1, 1, 0, 0, 0, 0]
         * 21		[0, 0, 0, 0, 0, 1, 1, 0]
         * 22		[0, 1, 1, 1, 0, 0, 0, 0]
         * 23		[0, 0, 1, 0, 0, 1, 1, 0]
         * 24		[0, 0, 1, 0, 0, 0, 0, 0]
         * 25		[0, 0, 1, 0, 1, 1, 1, 0]
         * 26		[0, 0, 1, 1, 0, 1, 0, 0]
         * 27		[0, 0, 0, 0, 1, 1, 0, 0]
         * 28		[0, 1, 1, 0, 0, 0, 0, 0] *
         * 29		[0, 0, 0, 0, 1, 1, 1, 0]
         * last     [0, 0, 0, 0, 1, 1, 1, 0]
         *
         * Process finished with exit code 0
         *
         *
         */


    }
}
