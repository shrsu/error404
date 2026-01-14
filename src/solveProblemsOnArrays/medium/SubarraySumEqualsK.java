package solveProblemsOnArrays.medium;

import java.util.HashMap;

public class SubarraySumEqualsK {

    /**
     * Returns the number of subarrays whose sum equals k.
     *
     * @param nums input array
     * @param k    target sum
     * @return count of subarrays with sum k
     */
    public int subarraySum(int[] nums, int k) {

        // Map to store prefix sum frequencies
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();

        int prefixSum = 0;
        int count = 0;

        // Base case:
        // One way to have a prefix sum of 0 before processing elements
        prefixSumCount.put(0, 1);

        for (int num : nums) {

            // Update prefix sum
            prefixSum += num;

            // Required prefix sum to form a subarray with sum k
            int required = prefixSum - k;

            // If such prefix sum exists, add its frequency
            count += prefixSumCount.getOrDefault(required, 0);

            // Store/update current prefix sum frequency
            prefixSumCount.put(
                    prefixSum,
                    prefixSumCount.getOrDefault(prefixSum, 0) + 1
            );
        }

        return count;
    }
}
