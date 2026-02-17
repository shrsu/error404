package recursionPatterns.subsequencesPattern;

public class CountOfAllSubsequencesWithSumK {

    /**
     * Main function to count subsequences with sum equal to k
     *
     * @param arr Input array
     * @param k   Target sum
     * @return Number of subsequences whose sum equals k
     */
    public int countSubsequencesWithSumK(int[] arr, int k) {
        return recurse(arr, k, 0, 0);
    }

    /**
     * Recursive helper function
     *
     * @param arr     Input array
     * @param k       Target sum
     * @param index   Current index in array
     * @param currSum Current sum of chosen subsequence
     *
     * @return Number of valid subsequences from this point
     */
    private int recurse(int[] arr, int k, int index, int currSum) {

        // Case 1: Found a valid subsequence
        if (currSum == k) {
            return 1;
        }

        // Case 2: Invalid path (sum exceeded or no elements left)
        if (currSum > k || index == arr.length) {
            return 0;
        }

        // Include current element
        int include = recurse(arr, k, index + 1, currSum + arr[index]);

        // Exclude current element
        int exclude = recurse(arr, k, index + 1, currSum);

        // Total valid subsequences
        return include + exclude;
    }
}
