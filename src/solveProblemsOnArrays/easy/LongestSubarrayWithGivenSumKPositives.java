package solveProblemsOnArrays.easy;

public class LongestSubarrayWithGivenSumKPositives {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        // Maximum length of subarray with sum k
        int maxLen = 0;

        // Sliding window pointers
        int left = 0, right = 0;

        // Sum of the current window
        int sum = nums[0];

        // Traverse the array
        while (right < n) {

            // Shrink window if sum exceeds k
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            // Check if current window sum equals k
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Expand the window
            right++;
            if (right < n) {
                sum += nums[right];
            }
        }

        return maxLen;
    }
}