package solveProblemsOnArrays.medium;

public class KadanesAlgorithmMaximumSubarraySum {

    /**
     * Returns the largest sum of any contiguous subarray.
     *
     * @param nums input array, length >= 1
     * @return maximum subarray sum
     */
    public int maxSubArray(int[] nums) {
        // Initialize both to the first element to handle all-negative arrays
        int currentMax = nums[0];
        int globalMax  = nums[0];

        // Iterate from the second element
        for (int i = 1; i < nums.length; i++) {
            // Either extend the current subarray or start a new subarray at nums[i]
            currentMax = Math.max(nums[i], currentMax + nums[i]);

            // Update global maximum if needed
            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;
    }
}

