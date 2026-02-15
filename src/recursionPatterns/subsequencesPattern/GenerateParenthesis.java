package recursionPatterns.subsequencesPattern;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    /**
     * Backtracking function to build valid parentheses combinations.
     *
     * @param curr  Current parentheses string being built
     * @param open  Number of '(' used so far
     * @param close Number of ')' used so far
     * @param n     Total pairs of parentheses required
     * @param res   List to store all valid combinations
     */
    private void backtrack(String curr, int open, int close, int n, List<String> res) {

        // Base case: if the current string length is 2*n, it is complete
        if (curr.length() == 2 * n) {
            res.add(curr);
            return;
        }

        // Option 1: Add '(' if we still have opening parentheses left
        if (open < n) {
            backtrack(curr + "(", open + 1, close, n, res);
        }

        // Option 2: Add ')' only if it keeps the sequence valid
        if (close < open) {
            backtrack(curr + ")", open, close + 1, n, res);
        }
    }

    /**
     * Main function to generate all valid parentheses combinations.
     *
     * @param n Number of pairs of parentheses
     * @return List of valid parentheses combinations
     */
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        // Start backtracking with empty string and zero counts
        backtrack("", 0, 0, n, res);

        return res;
    }
}
