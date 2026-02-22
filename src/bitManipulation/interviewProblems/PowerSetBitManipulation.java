package bitManipulation.interviewProblems;

import java.util.ArrayList;
import java.util.List;

public class PowerSetBitManipulation {

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
}
