package solveProblemsOnArrays.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSum0 {

    // Returns the length of the longest subarray with sum equal to 0
    public int maxLen(int[] arr, int n) {

        // Map to store prefixSum -> first index where it appears
        Map<Integer, Integer> prefixSumIndex = new HashMap<>();

        int prefixSum = 0;   // Running prefix sum
        int maxLength = 0;   // Length of the longest zero-sum subarray

        // Traverse the array
        for (int i = 0; i < n; i++) {

            // Update prefix sum
            prefixSum += arr[i];

            // Case 1: Prefix sum becomes zero
            // Subarray from index 0 to i has sum = 0
            if (prefixSum == 0) {
                maxLength = i + 1;
            }

            // Case 2: Prefix sum seen before
            // Subarray between previous index + 1 and i has sum = 0
            else if (prefixSumIndex.containsKey(prefixSum)) {
                int previousIndex = prefixSumIndex.get(prefixSum);
                maxLength = Math.max(maxLength, i - previousIndex);
            }

            // Case 3: First time seeing this prefix sum
            else {
                prefixSumIndex.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}
