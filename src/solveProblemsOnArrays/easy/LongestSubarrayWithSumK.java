package solveProblemsOnArrays.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {

    // Method to find the longest subarray with sum equal to k
    public int getLongestSubarray(int[] a, int k) {
        int n = a.length;

        // prefix sum -> earliest index
        Map<Integer, Integer> preSumMap = new HashMap<>();

        int sum = 0;      // Running prefix sum
        int maxLen = 0;   // Longest subarray length

        for (int i = 0; i < n; i++) {
            sum += a[i];

            // Case 1: Subarray from index 0 to i
            if (sum == k) {
                maxLen = i + 1;
            }

            // Case 2: Subarray ending at i with sum k
            int rem = sum - k;
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // Store first occurrence of prefix sum
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

}

