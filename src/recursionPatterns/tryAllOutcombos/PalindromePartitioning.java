package recursionPatterns.tryAllOutcombos;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    // Check if s[low..high] is a palindrome (two-pointer)
    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }

    /**
     * Backtracking function to generate all palindrome partitions.
     * <p>
     * start   → current index in string from where we want to cut
     * current → current partition (list of chosen palindromic substrings)
     * ans     → final list of all valid partitions
     */
    private void backtrack(String s, int start, List<String> current, List<List<String>> ans) {

        // Base case: entire string has been partitioned
        if (start == s.length()) {
            ans.add(new ArrayList<>(current)); // add a copy
            return;
        }

        // Try all possible substrings starting at 'start'
        for (int end = start; end < s.length(); end++) {

            // If s[start..end] is palindrome, choose it
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1));  // choose

                backtrack(s, end + 1, current, ans);       // explore

                current.remove(current.size() - 1);        // backtrack
            }
        }
    }

    // Main function
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), ans);
        return ans;
    }
}
