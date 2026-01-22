package solveProblemsOnArrays.hard;

public class MaximumProductSubarray {

    public int maxProductSubArray(int[] nums) {
        int n = nums.length;

        // Prefix and suffix products
        int prefix = 1;
        int suffix = 1;

        // Stores the maximum product found so far
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            // Reset prefix product if it becomes zero
            if (prefix == 0) {
                prefix = 1;
            }

            // Reset suffix product if it becomes zero
            if (suffix == 0) {
                suffix = 1;
            }

            // Compute prefix product from left
            prefix *= nums[i];

            // Compute suffix product from right
            suffix *= nums[n - i - 1];

            // Update maximum product
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }

        return maxProduct;
    }
}
