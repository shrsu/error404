package stringsBasicAndMedium.basicAndEasyProblems;

import java.util.Arrays;

public class LongestCommonPrefix {

    /**
     * Finds the longest common prefix among an array of strings.
     *
     * @param strs array of input strings
     * @return longest common prefix, or empty string if none exists
     */
    public String longestCommonPrefix(String[] strs) {
        // Edge case: empty input
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Sort the array lexicographically
        Arrays.sort(strs);

        // Get the first and last strings after sorting
        String first = strs[0];
        String last = strs[strs.length - 1];

        StringBuilder prefix = new StringBuilder();

        // Compare characters of the first and last strings
        int minLength = Math.min(first.length(), last.length());
        for (int i = 0; i < minLength; i++) {
            // Stop at the first mismatch
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }
            prefix.append(first.charAt(i));
        }

        return prefix.toString();
    }
}
