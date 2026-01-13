package solveProblemsOnArrays.medium;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInAnArrayProblem {

    // Function to find all leaders in the array
    public ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        // Edge case: empty array
        if (nums.length == 0) {
            return ans;
        }

        // Step 1: Last element is always a leader
        int max = nums[nums.length - 1];
        ans.add(max);

        // Step 2: Traverse from right to left
        for (int i = nums.length - 2; i >= 0; i--) {
            // If current element is greater than max so far
            if (nums[i] > max) {
                ans.add(nums[i]);
                max = nums[i]; // Update max
            }
        }

        // Step 3: Reverse to maintain left-to-right order
        Collections.reverse(ans);

        return ans;
    }
}

