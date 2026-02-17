package recursionPatterns.subsequencesPattern;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {

    /**
     * Main function that returns all valid combinations.
     *
     * @param arr    Input array of distinct candidates
     * @param target Target sum
     * @return List of all unique combinations
     */
    public List<List<Integer>> combinationSum(int[] arr, int target) {

        // Stores final result
        List<List<Integer>> ans = new ArrayList<>();

        // Stores current combination
        List<Integer> current = new ArrayList<>();

        // Start backtracking from index 0
        backtrackRecursive(arr, 0, target, current, ans);

        return ans;
    }

    /**
     * Backtracking function
     *
     * @param arr     Input candidates array
     * @param index   Current position in array
     * @param target  Remaining target to achieve
     * @param current Current combination being built
     * @param ans     Final answer list
     */
    private void backtrackRecursive(int[] arr, int index, int target, List<Integer> current, List<List<Integer>> ans) {

        /**
         * BASE CASE:
         * If we reached end of array
         */
        if (index == arr.length) {

            // If target becomes 0, current combination is valid
            if (target == 0) {
                ans.add(new ArrayList<>(current)); // Add copy
            }

            return;
        }

        /**
         * PICK CASE:
         * Pick current element only if it does not exceed target
         */
        if (arr[index] <= target) {

            // Choose element
            current.add(arr[index]);

            // Stay at same index (reuse allowed)
            backtrackRecursive(arr, index, target - arr[index], current, ans);

            // BACKTRACK: remove last element
            current.remove(current.size() - 1);
        }

        /**
         * NOT PICK CASE:
         * Move to next index
         */
        backtrackRecursive(arr, index + 1, target, current, ans);
    }

    /**
     * Backtracking function using for-loop approach.
     * <p>
     * This version is cleaner than pick/not-pick and easier to understand.
     *
     * @param arr     Input array of distinct candidates
     * @param start   Starting index for exploration (prevents duplicates)
     * @param target  Remaining sum required to reach original target
     * @param current Current combination being built
     * @param ans     Final result list containing all valid combinations
     */
    private void backtrackIterative(int[] arr, int start, int target, List<Integer> current, List<List<Integer>> ans) {

        /**
         * BASE CASE:
         * If target becomes 0, we found a valid combination.
         *
         * Example:
         * current = [2,2,3], target = 0
         */
        if (target == 0) {

            // Add a COPY of current combination to result
            // (Important: do NOT add current directly)
            ans.add(new ArrayList<>(current));

            return;
        }

        /**
         * Try all possible choices starting from 'start' index
         *
         * We use 'start' instead of 0 to:
         * - prevent duplicate combinations
         * - maintain order
         */
        for (int i = start; i < arr.length; i++) {

            /**
             * PRUNING STEP:
             * If current element is greater than remaining target,
             * skip it because it cannot contribute to valid combination.
             */
            if (arr[i] > target) continue;

            /**
             * PICK the current element
             *
             * Add arr[i] to current combination
             */
            current.add(arr[i]);

            /**
             * RECURSE:
             *
             * We pass 'i' again (NOT i+1)
             * because same element can be reused unlimited times.
             *
             * target is reduced by arr[i]
             */
            backtrackIterative(arr, i, target - arr[i], current, ans);

            /**
             * BACKTRACK:
             *
             * Remove last added element to explore other possibilities.
             *
             * This restores state before next iteration.
             */
            current.remove(current.size() - 1);
        }
    }

}
