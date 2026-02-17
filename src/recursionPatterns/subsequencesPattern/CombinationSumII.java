package recursionPatterns.subsequencesPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    /**
     * Returns all unique combinations where each number is used at most once.
     * Candidates may contain duplicates, but output combinations must be unique.
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // Sort to:
        // 1) group duplicates together (for skipping)
        // 2) allow early stopping (break when candidates[i] > target)
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    /**
     * Backtracking helper.
     *
     * @param candidates sorted array
     * @param indx       starting index for picking next elements
     * @param target     remaining sum to achieve
     * @param current    current combination being built
     * @param ans        final list of unique combinations
     */
    private void backtrack(int[] candidates, int indx, int target, List<Integer> current, List<List<Integer>> ans) {

        // BASE CASE: found a valid combination
        if (target == 0) {
            ans.add(new ArrayList<>(current)); // add copy
            return;
        }

        // Try each candidate starting from indx
        for (int i = indx; i < candidates.length; i++) {

            /**
             * SKIP DUPLICATES (IMPORTANT):
             * If the current value is the same as the previous value at the SAME depth,
             * skip it to avoid generating the same combination multiple times.
             *
             * Example: candidates = [1,1,2,...]
             * At indx = 0, picking the 2nd '1' as the first element produces duplicates.
             */
            if (i > indx && candidates[i] == candidates[i - 1]) {
                continue;
            }

            /**
             * EARLY STOP / PRUNING:
             * Since array is sorted, if candidates[i] > target,
             * all later elements will also be > target.
             */
            if (candidates[i] > target) {
                break;
            }

            // PICK current candidate
            current.add(candidates[i]);

            /**
             * Recurse with i+1 (NOT i) because each element can be used only once.
             */
            backtrack(candidates, i + 1, target - candidates[i], current, ans);

            // BACKTRACK: remove last chosen element
            current.remove(current.size() - 1);
        }
    }
}
