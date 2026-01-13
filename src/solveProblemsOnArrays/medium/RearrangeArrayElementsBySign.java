package solveProblemsOnArrays.medium;

public class RearrangeArrayElementsBySign {

    /**
     * Rearranges the array so that:
     * - The array starts with a positive number
     * - Positive and negative numbers alternate
     * - Relative order of positives and negatives is preserved
     *
     * @param nums input array with equal number of positive and negative integers
     * @return rearranged array following the required conditions
     */
    public int[] rearrangeBySign(int[] nums) {
        int n = nums.length;

        // Result array
        int[] result = new int[n];

        // Even indices for positives, odd indices for negatives
        int posIndex = 0;
        int negIndex = 1;

        // Single pass through the input array
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                // Place positive number at the next even index
                result[posIndex] = nums[i];
                posIndex += 2;
            } else {
                // Place negative number at the next odd index
                result[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return result;
    }
}

