package recursionPatterns.subsequencesPattern;

public class CheckIfThereExistsASubsequenceWithSumK {

    /* ============================================================
       VERSION 1: Optimized Version (Only for NON-NEGATIVE numbers)
       ============================================================

       This version uses pruning:
       If currSum > k, we stop exploring that path.

       This works ONLY when array contains non-negative numbers.
       Because sum can never decrease later.
    */

    public boolean existsSubsequenceSumK_NonNegative(int[] arr, int k) {
        return recurseNonNegative(arr, k, 0, 0);
    }

    /**
     * Recursive helper for non-negative numbers
     *
     * @param arr     Input array (non-negative numbers only)
     * @param k       Target sum
     * @param index   Current index in array
     * @param currSum Current accumulated sum
     * @return true if valid subsequence exists
     */
    private boolean recurseNonNegative(int[] arr, int k, int index, int currSum) {

        // Case 1: Found valid subsequence
        if (currSum == k) {
            return true;
        }

        // Case 2: Invalid path
        // - currSum > k → cannot decrease later (only true for non-negative numbers)
        // - index reached end → no elements left
        if (currSum > k || index == arr.length) {
            return false;
        }

        // Choice 1: Include current element
        boolean include = recurseNonNegative(arr, k, index + 1, currSum + arr[index]);

        // Short-circuit optimization
        if (include) {
            return true;
        }

        // Choice 2: Exclude current element
        boolean exclude = recurseNonNegative(arr, k, index + 1, currSum);

        return exclude;
    }


    /* ============================================================
       VERSION 2: General Version (Works with NEGATIVE numbers)
       ============================================================

       This version DOES NOT use pruning.

       Because even if currSum > k,
       future negative numbers could reduce the sum.
    */

    public boolean existsSubsequenceSumK_General(int[] arr, int k) {
        return recurseGeneral(arr, k, 0, 0);
    }

    /**
     * Recursive helper that works for all integers (positive, negative, zero)
     *
     * @param arr     Input array
     * @param k       Target sum
     * @param index   Current index
     * @param currSum Current accumulated sum
     * @return true if valid subsequence exists
     */
    private boolean recurseGeneral(int[] arr, int k, int index, int currSum) {

        // Base case: processed all elements
        if (index == arr.length) {
            return currSum == k;
        }

        // Choice 1: Include current element
        boolean include = recurseGeneral(arr, k, index + 1, currSum + arr[index]);

        // Short-circuit if found
        if (include) {
            return true;
        }

        // Choice 2: Exclude current element
        boolean exclude = recurseGeneral(arr, k, index + 1, currSum);

        return exclude;
    }
}

