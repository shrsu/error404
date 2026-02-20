package recursionPatterns.tryAllOutcombos;

public class WordSearch {

    // Main function: checks if word exists in the board
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // Try starting DFS from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // DFS tries to match word[index...] starting from board[i][j]
    private boolean dfs(int i, int j, char[][] board, String word, int index) {
        int m = board.length;
        int n = board[0].length;

        // 1) Boundary check
        if (i < 0 || i >= m || j < 0 || j >= n) return false;

        // 2) Character mismatch check
        if (board[i][j] != word.charAt(index)) return false;

        // 3) If this is the last character and it matches, we're done
        if (index == word.length() - 1) return true;

        // 4) Mark current cell as visited so we don't reuse it in this path
        char original = board[i][j];
        board[i][j] = '.'; // visited marker (safe because input is only letters)

        // 5) Explore 4 directions for next character
        boolean found = dfs(i, j + 1, board, word, index + 1) || // right
                dfs(i + 1, j, board, word, index + 1) || // down
                dfs(i - 1, j, board, word, index + 1) || // up
                dfs(i, j - 1, board, word, index + 1);   // left

        // 6) Backtrack: restore original character before returning
        board[i][j] = original;

        return found;
    }
}
