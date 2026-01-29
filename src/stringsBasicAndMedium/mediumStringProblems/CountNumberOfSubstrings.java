package stringsBasicAndMedium.mediumStringProblems;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfSubstrings {

    /**
     * Counts the number of substrings with at most k distinct characters.
     *
     * @param s the input string
     * @param k the maximum number of distinct characters allowed
     * @return count of valid substrings
     */
    public static int atMostKDistinct(String s, int k) {
        int left = 0;
        int result = 0;
        Map<Character, Integer> freq = new HashMap<>();

        // Expand the window using the right pointer
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            freq.put(current, freq.getOrDefault(current, 0) + 1);

            // Shrink the window if distinct characters exceed k
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);

                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }

            // All substrings ending at 'right' and starting from 'left' are valid
            result += (right - left + 1);
        }

        return result;
    }

    /**
     * Counts the number of substrings with exactly k distinct characters.
     *
     * @param s the input string
     * @param k the exact number of distinct characters required
     * @return count of valid substrings
     */
    public static int countSubstrings(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }
}
