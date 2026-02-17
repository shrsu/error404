package recursionPatterns.subsequencesPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetsI {

    /* =========================================================
       METHOD 1: BITMASKING APPROACH
       =========================================================
       Idea:
       - Total subsets = 2^n
       - Each number from 0 to (2^n - 1) represents a subset
       - Each bit tells whether to include that element
       ========================================================= */
    public List<Integer> subsetSumsBitmask(int[] arr) {

        int n = arr.length;

        // List to store subset sums
        List<Integer> sums = new ArrayList<>();

        // Loop through all subset masks
        // Example: if n = 3 → masks from 000 to 111 (0 to 7)
        for (int mask = 0; mask < (1 << n); mask++) {

            int sum = 0;

            // Check each bit position
            for (int i = 0; i < n; i++) {

                /*
                 Check if i-th bit is set in mask

                 (mask & (1 << i)) != 0 means:
                 include arr[i] in this subset
                 */
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                }
            }

            // Store subset sum
            sums.add(sum);
        }

        // Sort in increasing order
        Collections.sort(sums);

        return sums;
    }



    /* =========================================================
       METHOD 2: RECURSION APPROACH (INCLUDE / EXCLUDE)
       =========================================================
       Idea:
       - At each index, we have 2 choices:
         1. Include element
         2. Exclude element

       - This generates all 2^n subsets
       ========================================================= */


    // Helper recursive function
    private void generateSums(int index, int currentSum, int[] arr, List<Integer> sums) {

        /*
         Base Case:
         If we reached end of array,
         store the current sum
         */
        if (index == arr.length) {
            sums.add(currentSum);
            return;
        }

        /*
         Choice 1: Include current element
         Add arr[index] to sum
         */
        generateSums(index + 1, currentSum + arr[index], arr, sums);

        /*
         Choice 2: Exclude current element
         Do not add arr[index]
         */
        generateSums(index + 1, currentSum, arr, sums);
    }


    // Main recursive method
    public List<Integer> subsetSumsRecursive(int[] arr) {

        List<Integer> sums = new ArrayList<>();

        // Start recursion from index 0 with sum 0
        generateSums(0, 0, arr, sums);

        // Sort in increasing order
        Collections.sort(sums);

        return sums;
    }
}
