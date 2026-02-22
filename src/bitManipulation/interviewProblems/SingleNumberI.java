package bitManipulation.interviewProblems;

public class SingleNumberI {

    public int singleNumber(int[] nums) {

        // Step 1: Initialize result
        // Start with 0 because x ^ 0 = x
        int ans = 0;


        // Step 2: XOR all elements
        for (int num : nums) {

            // Duplicate numbers cancel out
            ans = ans ^ num;
        }


        // Step 3: Return single number
        return ans;
    }
}
