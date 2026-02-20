package recursionPatterns.tryAllOutcombos;

public class WordSearch {

    // Main function: checks if word exists in the board
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // Try starting DFS from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, m, n, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // DFS tries to match word[index...] starting from board[i][j]
    private boolean dfs(int i, int j, int m, int n, char[][] board, String word, int indx) {

        // Check bounds first
        if (!(i < m && i >= 0 && j < n && j >= 0)) return false;

        // Check character match
        if (board[i][j] != word.charAt(indx)) return false;

        // If last character matched, word found
        if (indx == word.length() - 1) return true;

        // Mark visited
        char c = board[i][j];
        board[i][j] = '.';

        // Explore 4 directions
        boolean found = dfs(i, j + 1, m, n, board, word, indx + 1) || dfs(i + 1, j, m, n, board, word, indx + 1) || dfs(i - 1, j, m, n, board, word, indx + 1) || dfs(i, j - 1, m, n, board, word, indx + 1);

        // Backtrack
        board[i][j] = c;

        return found;
    }
}
