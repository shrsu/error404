package binarySearch;

public class SearchInRotatedSortedArrayI {

    /**
     * Search target in a rotated sorted array in O(log n) time.
     *
     * @param nums   rotated sorted array with distinct values
     * @param target value to search for
     * @return index of target if found, otherwise -1
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // Use safe midpoint calculation to avoid overflow
            int mid = low + (high - low) / 2;

            // Found target
            if (nums[mid] == target) {
                return mid;
            }

            // Determine which half is sorted
            if (nums[low] <= nums[mid]) {
                // Left half [low..mid] is sorted
                if (nums[low] <= target && target < nums[mid]) {
                    // Target lies in sorted left half
                    high = mid - 1;
                } else {
                    // Target is in right half
                    low = mid + 1;
                }
            } else {
                // Right half [mid..high] is sorted
                if (nums[mid] < target && target <= nums[high]) {
                    // Target lies in sorted right half
                    low = mid + 1;
                } else {
                    // Target is in left half
                    high = mid - 1;
                }
            }
        }

        // Target not present
        return -1;
    }
}

