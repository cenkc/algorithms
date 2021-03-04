package algorithms;

/**
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/
 * Difficulty : Medium
 * Related Topics : Depth-first Search, Breadth-first Search, Union Find
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border,
 * which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 * created by cenkc on 8/12/2020
 */
public class SurroundedRegions {

    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // up, down, right, left

    /**
     * Runtime: 1 ms
     * Memory Usage: 41.6 MB
     *
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        boolean[][] visited = new boolean[board.length][board[0].length];

        // traverse left & right borders and replace 'O' with '*' temporarily
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0, visited);
            dfs(board, i, board[0].length - 1, visited);
        }

        // traverse up & down borders and replace 'O' with '*' temporarily
        for (int j = 0; j < board[0].length; j++) {
            dfs(board, 0, j, visited);
            dfs(board, board.length - 1, j, visited);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O'; // rollback 'O' 's
            }
        }

    }

    private static void dfs(char[][] board, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != 'O') return;
        board[i][j] = '*';
        for (int[] dir : directions) {
            dfs(board, i + dir[0], j + dir[1], visited);
        }
    }
}
