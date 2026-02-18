package recursionPatterns.subsequencesPattern;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    /**
     * Main function to find all valid combinations
     *
     * @param k number of elements required in combination
     * @param n target sum
     * @return list of all valid combinations
     */
    public List<List<Integer>> combinationSum3(int k, int n) {

        // Result list to store all valid combinations
        List<List<Integer>> result = new ArrayList<>();

        // Temporary list to store current combination
        List<Integer> current = new ArrayList<>();

        // Start backtracking from number 1
        findCombinations(k, n, 1, current, result);

        return result;
    }

    /**
     * Backtracking function
     *
     * @param k            remaining numbers to pick
     * @param remainingSum remaining sum needed
     * @param start        current number to consider
     * @param current      current combination
     * @param result       stores all valid combinations
     */
    private void findCombinations(int k, int remainingSum, int start, List<Integer> current, List<List<Integer>> result) {

        /**
         * Case 1: Valid combination found
         * If exactly k numbers used and sum becomes 0
         */
        if (k == 0 && remainingSum == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        /**
         * Case 2: Invalid cases (pruning)
         */

        // No more numbers needed OR sum becomes negative
        if (k == 0 || remainingSum < 0) {
            return;
        }

        // Numbers only allowed from 1 to 9
        if (start > 9) {
            return;
        }

        /**
         * Try all possible numbers from start to 9
         */
        for (int num = start; num <= 9; num++) {

            // Include current number
            current.add(num);

            // Recurse with:
            // k reduced by 1
            // sum reduced by num
            // next number = num + 1 (no reuse allowed)
            findCombinations(k - 1, remainingSum - num, num + 1, current, result);

            // Backtrack: remove last added number
            current.remove(current.size() - 1);
        }
    }
}
