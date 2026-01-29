package stringsBasicAndMedium.mediumStringProblems;

import java.util.HashMap;
import java.util.Map;

public class SumOfBeautyOfAllSubstring {

    /**
     * Returns the sum of beauty values of all substrings of the given string.
     *
     * @param s input string consisting of lowercase English letters
     * @return total beauty sum
     */
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        // Fix the starting index of the substring
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> freq = new HashMap<>();

            // Extend the substring ending at index j
            for (int j = i; j < n; j++) {
                char current = s.charAt(j);
                freq.put(current, freq.getOrDefault(current, 0) + 1);

                int maxFreq = Integer.MIN_VALUE;
                int minFreq = Integer.MAX_VALUE;

                // Find maximum and minimum (non-zero) frequencies
                for (int count : freq.values()) {
                    maxFreq = Math.max(maxFreq, count);
                    minFreq = Math.min(minFreq, count);
                }

                // Add the beauty of the current substring
                sum += (maxFreq - minFreq);
            }
        }

        return sum;
    }
}
