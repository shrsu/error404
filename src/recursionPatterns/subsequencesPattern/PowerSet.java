package recursionPatterns.subsequencesPattern;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    /**
     * Generates all subsequences using bit manipulation.
     * <p>
     * Each number from 0 to (2^n - 1) represents a subsequence.
     * The bits in the number indicate whether to include characters.
     * <p>
     * Example:
     * mask = 5 (binary 101)
     * include s[0], exclude s[1], include s[2]
     *
     * @param s Input string
     * @return List of all subsequences
     */
    public List<String> getSubsequencesIterative(String s) {

        int n = s.length();

        // Total number of subsequences = 2^n
        int total = 1 << n;

        List<String> subsequences = new ArrayList<>();

        // Loop through all possible masks
        for (int mask = 0; mask < total; mask++) {

            StringBuilder subseq = new StringBuilder();

            // Check each bit position
            for (int i = 0; i < n; i++) {

                // Check if i-th bit is set
                if ((mask & (1 << i)) != 0) {

                    // Include character in subsequence
                    subseq.append(s.charAt(i));
                }
            }

            // Add generated subsequence
            subsequences.add(subseq.toString());
        }

        return subsequences;
    }

    /**
     * Recursive helper function.
     * <p>
     * At each index, we make two decisions:
     * 1. Exclude character
     * 2. Include character
     *
     * @param s       Input string
     * @param index   Current index in string
     * @param current Current subsequence being built
     * @param result  List to store all subsequences
     */
    private void helper(String s, int index, StringBuilder current, List<String> result) {

        // Base case: reached end of string
        if (index == s.length()) {

            // Add current subsequence
            result.add(current.toString());
            return;
        }

        // Choice 1: Exclude current character
        helper(s, index + 1, current, result);

        // Choice 2: Include current character
        current.append(s.charAt(index));

        helper(s, index + 1, current, result);

        // Backtrack: remove last character
        current.deleteCharAt(current.length() - 1);
    }

    /**
     * Generates all subsequences using recursion.
     *
     * @param s Input string
     * @return List of subsequences
     */
    public List<String> getSubsequencesRecursive(String s) {

        List<String> result = new ArrayList<>();

        StringBuilder current = new StringBuilder();

        helper(s, 0, current, result);

        return result;
    }
}
