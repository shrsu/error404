package binarySearch.bsOnAnswers;

public class FindTheSmallestDivisor {

    /**
     * Helper: compute the sum of ceil(nums[i] / divisor) for all nums.
     * Uses integer arithmetic to avoid floating point and to be fast.
     *
     * @param nums    input array
     * @param divisor candidate divisor (> 0)
     * @return sum of rounded-up divisions
     */
    private long sumWithDivisor(int[] nums, int divisor) {
        long sum = 0L;
        for (int num : nums) {
            // ceil(num / divisor) = (num + divisor - 1) / divisor using integer arithmetic
            sum += (num + divisor - 1) / divisor;
        }
        return sum;
    }

    /**
     * Return the smallest divisor such that the sum of ceil(nums[i] / divisor)
     * is <= threshold. If impossible, returns -1.
     *
     * Time complexity: O(N * log(max(nums))) where N = nums.length
     * Space complexity: O(1)
     *
     * @param nums      input array (nums.length >= 1)
     * @param threshold target threshold (>= nums.length per problem constraints)
     * @return smallest divisor or -1 if impossible
     */
    public int smallestDivisor(int[] nums, int threshold) {
        // Optional feasibility check: each element contributes at least 1 to sum.
        if (threshold < nums.length) return -1;

        // Search bounds: divisor in [1, max(nums)]
        int lo = 1;
        int hi = 0;
        for (int n : nums) hi = Math.max(hi, n);

        int answer = hi; // safe fallback: hi always works (divisor = max(nums) => sum = nums.length)
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long sum = sumWithDivisor(nums, mid);

            if (sum <= threshold) {
                // mid works; try to find a smaller valid divisor
                answer = mid;
                hi = mid - 1;
            } else {
                // mid too small (sum too large); need larger divisor
                lo = mid + 1;
            }
        }

        return answer;
    }
}
