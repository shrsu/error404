package recursionPatterns.tryAllOutcombos;

public class SudokuSolver {

    /**
     * Checks whether placing character 'c' at board[row][col] is valid
     * according to Sudoku rules.
     */
    private boolean isValid(char[][] board, int row, int col, char c) {

        // Check if 'c' already exists in the same column
        for (int r = 0; r < 9; r++) {
            if (board[r][col] == c) return false;
        }

        // Check if 'c' already exists in the same row
        for (int cc = 0; cc < 9; cc++) {
            if (board[row][cc] == c) return false;
        }

        // Check if 'c' already exists in the 3x3 sub-box
        int boxRowStart = 3 * (row / 3);
        int boxColStart = 3 * (col / 3);

        for (int r = boxRowStart; r < boxRowStart + 3; r++) {
            for (int cc = boxColStart; cc < boxColStart + 3; cc++) {
                if (board[r][cc] == c) return false;
            }
        }

        // If it passes all checks, it's a valid placement
        return true;
    }

    /**
     * Solves Sudoku in-place using backtracking.
     * Returns true if solved, otherwise false.
     */
    public boolean solveSudoku(char[][] board) {

        // Traverse the board to find an empty cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // If current cell is empty, try filling it
                if (board[row][col] == '.') {

                    // Try all digits from '1' to '9'
                    for (char c = '1'; c <= '9'; c++) {

                        // Place c only if it does not violate Sudoku rules
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c; // choose

                            // Recurse to solve the rest of the board
                            if (solveSudoku(board)) {
                                return true; // solution found, stop early
                            }

                            // If recursion failed, undo the choice (backtrack)
                            board[row][col] = '.';
                        }
                    }

                    // If none of '1'..'9' works here, this path is invalid
                    return false;
                }
            }
        }

        // No empty cells left => solved
        return true;
    }
}
