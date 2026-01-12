package solveProblemsOnArrays.medium;

public class KadanesAlgorithmSubarrayWithMaximumSubarraySum {

    /**
     * Returns the maximum subarray sum along with its start and end indices.
     *
     * @param nums input array, length >= 1
     * @return int[] {maxSum, startIndex, endIndex}
     */
    public int[] maxSubArrayWithIndices(int[] nums) {

        int currentMax = nums[0];
        int globalMax = nums[0];

        int start = 0;        // start index of best subarray
        int end = 0;          // end index of best subarray
        int tempStart = 0;    // potential start index

        for (int i = 1; i < nums.length; i++) {

            // Decide whether to extend or start fresh
            if (nums[i] > currentMax + nums[i]) {
                currentMax = nums[i];
                tempStart = i;
            } else {
                currentMax += nums[i];
            }

            // Update global max and indices
            if (currentMax > globalMax) {
                globalMax = currentMax;
                start = tempStart;
                end = i;
            }
        }

        return new int[]{globalMax, start, end};
    }
}
