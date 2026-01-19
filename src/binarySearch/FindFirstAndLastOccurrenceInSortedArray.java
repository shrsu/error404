package binarySearch;

public class FindFirstAndLastOccurrenceInSortedArray {

    // Main function that returns start and end index of target
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];

        ans[0] = findLeft(nums, target);   // first occurrence
        ans[1] = findRight(nums, target);  // last occurrence

        return ans;
    }

    // Binary search to find the leftmost (first) occurrence
    private int findLeft(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;          // possible answer
                high = mid - 1;     // move left to find earlier index
            } else if (nums[mid] < target) {
                low = mid + 1;      // target is on the right
            } else {
                high = mid - 1;     // target is on the left
            }
        }
        return ans;
    }

    // Binary search to find the rightmost (last) occurrence
    private int findRight(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;          // possible answer
                low = mid + 1;      // move right to find later index
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
