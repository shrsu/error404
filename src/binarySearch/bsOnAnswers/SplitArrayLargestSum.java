package binarySearch.bsOnAnswers;

import java.util.Arrays;

public class SplitArrayLargestSum {

    // Returns the number of subarrays needed
    // if no subarray is allowed to have sum > maxAllowedSum
    private int countPartitions(int maxAllowedSum, int[] nums) {
        int partitions = 1;      // Start with one subarray
        int currentSum = 0;      // Sum of the current subarray

        for (int num : nums) {
            // If adding current number stays within the limit
            if (currentSum + num <= maxAllowedSum) {
                currentSum += num;
            }
            // Otherwise, start a new subarray
            else {
                partitions++;
                currentSum = num;
            }
        }

        return partitions;
    }

    public int splitArray(int[] nums, int k) {
        // Minimum possible largest sum
        int left = Arrays.stream(nums).max().getAsInt();

        // Maximum possible largest sum
        int right = Arrays.stream(nums).sum();

        int answer = right;

        // Binary search over possible largest subarray sums
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check how many subarrays are needed with mid as max sum
            if (countPartitions(mid, nums) > k) {
                // Too many subarrays → mid is too small
                left = mid + 1;
            } else {
                // Valid split → try to minimize further
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }
}
