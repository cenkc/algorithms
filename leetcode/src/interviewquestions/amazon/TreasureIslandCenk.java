package interviewquestions.amazon;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Treasure Island
 * https://leetcode.com/discuss/interview-question/347457
 * Related Topics : Depth-first Search, Breadth-first Search
 *
 * You have a map that marks the location of a treasure island.
 * Some of the map area has jagged rocks and dangerous reefs.
 * Other areas are safe to sail in.
 * There are other explorers trying to find the treasure.
 * So you must figure out a shortest route to the treasure island.
 *
 * Assume the map area is a two dimensional grid,
 * represented by a matrix of characters.
 * You must start from the top-left corner of the map
 * and can move one block up, down, left or right at a time.
 * The treasure island is marked as X in a block of the matrix.
 * X will not be at the top-left corner.
 * Any block with dangerous rocks or reefs will be marked as D.
 * You must not enter dangerous blocks. You cannot leave the map area.
 * Other areas O are safe to sail in. The top-left corner is always safe.
 * Output the minimum number of steps to get to the treasure.
 *
 * Example:
 *
 * Input:
 * [['O', 'O', 'O', 'O'],
 *  ['D', 'O', 'D', 'O'],
 *  ['O', 'O', 'O', 'O'],
 *  ['X', 'D', 'D', 'O']]
 *
 * Output: 5
 * Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
 *
 * created by cenkc on 8/8/2020
 */
public class TreasureIslandCenk {
    // https://leetcode.com/discuss/interview-question/356150
    // taken from list of Amazon Online Assessment Questions :
    // https://leetcode.com/discuss/interview-question/344650/Amazon-Online-Assessment-Questions
    public static void main(String[] args) {
        // 5 steps
        char[][] island_1 = {
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}};
        // 6 steps
        char[][] island_2 = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'X'}
        };

        assertEquals(5, breadthFirstSearch(island_1));
        assertEquals(6, breadthFirstSearch(island_2));
    }

    private static int breadthFirstSearch(char[][] island) {
        if (island == null || island.length == 0) return 0;

        // 1) Create visited matrix
        boolean[][] visited = new boolean[island.length][island[0].length];
        // 2) Mark starting point as visited, 'true'
        visited[0][0] = true;
        // 3) Initialize step counter
        int steps = 0;
        // 4) Create an empty Queue and then add starting point into it
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(0, 0));

        while ( ! q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Coordinate current = q.poll();
                if (island[current.x][current.y] == 'X') {
                    return steps;
                }
                bfs(new Coordinate(current.x, current.y + 1), q, island, visited, steps); // up
                bfs(new Coordinate(current.x, current.y - 1), q, island, visited, steps); // down
                bfs(new Coordinate(current.x + 1, current.y), q, island, visited, steps); // right
                bfs(new Coordinate(current.x - 1, current.y), q, island, visited, steps); // left
            }
            steps++;
        }
        return steps;
    }

    private static void bfs(Coordinate coordinate, Queue<Coordinate> q, char[][] island, boolean[][] visited, int steps) {
        if (validCoordinate(coordinate, island, visited)) {
            q.add(coordinate);
            visited[coordinate.x][coordinate.y] = true;
        }
    }

    private static boolean validCoordinate(Coordinate coordinate, char[][] island, boolean[][] visited) {
        return coordinate != null &&
                coordinate.x >= 0 && coordinate.x < island.length &&
                coordinate.y >= 0 && coordinate.y < island[0].length &&
                island[coordinate.x][coordinate.y] != 'D' &&
                ! visited[coordinate.x][coordinate.y];
    }

    private static class Coordinate{
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
