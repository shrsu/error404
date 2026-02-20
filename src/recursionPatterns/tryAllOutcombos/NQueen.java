package recursionPatterns.tryAllOutcombos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {

    /**
     * Recursive backtracking function to place queens column by column.
     *
     * @param col           Current column where queen needs to be placed
     * @param board         Chessboard
     * @param n             Size of board
     * @param leftRow       Tracks which rows already contain a queen
     * @param upperDiagonal Tracks "/" diagonals under attack
     * @param lowerDiagonal Tracks "\" diagonals under attack
     * @param result        Stores all valid board configurations
     */
    private void solve(int col, char[][] board, int n, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal, List<List<String>> result) {

        // Base case: all queens successfully placed
        if (col == n) {
            List<String> solution = new ArrayList<>();

            // Convert board into list of strings
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }

            result.add(solution);
            return;
        }

        // Try placing queen in each row of current column
        for (int row = 0; row < n; row++) {

            // Check if placing queen is safe using hash arrays
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {

                // Place queen
                board[row][col] = 'Q';

                // Mark row and diagonals as occupied
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;

                // Recurse to place queen in next column
                solve(col + 1, board, n, leftRow, upperDiagonal, lowerDiagonal, result);

                // Backtrack: remove queen
                board[row][col] = '.';

                // Unmark row and diagonals
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }

    /**
     * Main function to solve N-Queens problem
     *
     * @param n Size of board
     * @return List of all valid board configurations
     */
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        // Initialize chessboard with empty cells
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        // Hash arrays for O(1) safety checking
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];

        // Start backtracking from column 0
        solve(0, board, n, leftRow, upperDiagonal, lowerDiagonal, result);

        return result;
    }
}
