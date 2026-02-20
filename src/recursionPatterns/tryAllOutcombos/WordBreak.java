package recursionPatterns.tryAllOutcombos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    /**
     * Returns true if the string s can be segmented into one or more words from wordDict.
     * <p>
     * Approach:
     * - Convert wordDict into a HashSet for O(1) lookup.
     * - Use DFS + memoization where dfs(start) answers:
     * "Can s.substring(start) be segmented?"
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        // Fast lookup for dictionary words
        Set<String> dict = new HashSet<>(wordDict);

        // memo[i] = whether s.substring(i) can be segmented (null = not computed yet)
        Boolean[] memo = new Boolean[s.length() + 1];

        return dfs(s, 0, dict, memo);
    }

    /**
     * DFS helper to check if s can be segmented starting from index 'start'.
     *
     * @param s     The input string
     * @param start Current index from which we want to segment the string
     * @param dict  HashSet of dictionary words for O(1) membership checks
     * @param memo  Memoization array to avoid recomputation
     * @return true if s.substring(start) can be segmented, else false
     */
    private boolean dfs(String s, int start, Set<String> dict, Boolean[] memo) {

        // Base case: successfully segmented the whole string
        if (start == s.length()) return true;

        // If already computed, return stored result
        if (memo[start] != null) return memo[start];

        // Try every possible end index to form the next word
        for (int end = start + 1; end <= s.length(); end++) {

            // Candidate word is s[start:end]
            String word = s.substring(start, end);

            // If it's in dict, recurse for the remaining suffix
            if (dict.contains(word) && dfs(s, end, dict, memo)) {
                return memo[start] = true; // Found a valid split
            }
        }

        // No valid split found starting at 'start'
        return memo[start] = false;
    }
}
