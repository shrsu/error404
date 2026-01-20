package binarySearch;

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Case 1: Target found
            if (nums[mid] == target) {
                return true;
            }

            // Case 2: Duplicates at boundaries — cannot determine sorted half
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // Case 3: Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;   // Search left half
                } else {
                    low = mid + 1;    // Search right half
                }
            }
            // Case 4: Right half is sorted
            else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;    // Search right half
                } else {
                    high = mid - 1;   // Search left half
                }
            }
        }

        // Target not found
        return false;
    }
}
