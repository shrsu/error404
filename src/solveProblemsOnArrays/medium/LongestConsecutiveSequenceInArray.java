package solveProblemsOnArrays.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceInArray {

    /**
     * Returns the length of the longest sequence of consecutive integers in nums.
     * Time:  O(n) average — each number is visited O(1) times on average.
     * Space: O(n) for the HashSet of unique elements.
     */
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        // Put all unique values into a HashSet for O(1) lookups
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // For each number, only start counting when it's the beginning of a sequence
        for (int v : set) {
            // If v-1 is present, v is not the start of a sequence
            if (!set.contains(v - 1)) {
                int current = v;
                int count = 1;

                // Count consecutive numbers v+1, v+2, ...
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                if (count > longest) {
                    longest = count;
                }
            }
        }

        return longest;
    }
}
