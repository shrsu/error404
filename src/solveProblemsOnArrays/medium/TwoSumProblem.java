package solveProblemsOnArrays.medium;

import java.util.Arrays;

public class TwoSumProblem {

    /*
     * Variant 1:
     * Checks whether any two numbers in the array sum up to the target.
     * Returns "YES" if such a pair exists, otherwise "NO".
     */
    public String twoSumExists(int[] arr, int target) {
        int n = arr.length;

        // Create an array to store values along with their original indices
        int[][] numsWithIndex = new int[n][2];

        // Populate the array: [value, originalIndex]
        for (int i = 0; i < n; i++) {
            numsWithIndex[i][0] = arr[i];
            numsWithIndex[i][1] = i;
        }

        // Sort based on values
        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize two pointers
        int left = 0;
        int right = n - 1;

        // Two-pointer traversal
        while (left < right) {
            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];

            if (sum == target) {
                return "YES";
            } else if (sum < target) {
                // Move left pointer to increase sum
                left++;
            } else {
                // Move right pointer to decrease sum
                right--;
            }
        }

        // No valid pair found
        return "NO";
    }

    /*
     * Variant 2:
     * Returns the original indices of the two numbers that sum up to target.
     * If no pair is found, returns {-1, -1}.
     */
    public int[] twoSumIndices(int[] arr, int target) {
        int n = arr.length;

        // Store value with original index
        int[][] numsWithIndex = new int[n][2];

        for (int i = 0; i < n; i++) {
            numsWithIndex[i][0] = arr[i];
            numsWithIndex[i][1] = i;
        }

        // Sort by value
        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0;
        int right = n - 1;

        // Two-pointer search
        while (left < right) {
            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];

            if (sum == target) {
                // Return original indices
                return new int[] {
                        numsWithIndex[left][1],
                        numsWithIndex[right][1]
                };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // No valid pair found
        return new int[] {-1, -1};
    }
}

