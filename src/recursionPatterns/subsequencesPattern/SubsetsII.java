package recursionPatterns.subsequencesPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    /**
     * Main function to generate all unique subsets.
     *
     * @param nums Input array that may contain duplicates
     * @return List of all unique subsets
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Step 1: Sort the array so duplicates are adjacent
        Arrays.sort(nums);

        // Result list to store all subsets
        List<List<Integer>> result = new ArrayList<>();

        // Temporary list to store current subset
        List<Integer> current = new ArrayList<>();

        // Start backtracking from index 0
        findSubsets(nums, 0, current, result);

        return result;
    }

    /**
     * Recursive backtracking function
     *
     * @param nums    Input array
     * @param start   Current index from where to pick elements
     * @param current Current subset being built
     * @param result  Stores all unique subsets
     */
    private void findSubsets(int[] nums, int start,
                             List<Integer> current,
                             List<List<Integer>> result) {

        // Step 2: Add a copy of current subset to result
        // Important: Must create new ArrayList, not reference
        result.add(new ArrayList<>(current));

        // Step 3: Try adding each remaining element
        for (int i = start; i < nums.length; i++) {

            /**
             * Step 4: Skip duplicate elements
             *
             * Condition explanation:
             * i > start → ensures we only skip duplicates at same recursion level
             * nums[i] == nums[i-1] → duplicate element found
             *
             * This prevents duplicate subsets.
             */
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 5: Include current element in subset
            current.add(nums[i]);

            // Step 6: Recurse for next index
            findSubsets(nums, i + 1, current, result);

            /**
             * Step 7: Backtrack
             * Remove last element before exploring next possibility
             */
            current.remove(current.size() - 1);
        }
    }
}
