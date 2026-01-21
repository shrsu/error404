package binarySearch.bsOn1DArrays;

public class BinarySearch {

    // Performs binary search on a sorted array
    // Returns index of target if found, otherwise -1
    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // Continue searching while the search space is valid
        while (low <= high) {

            // Calculate middle index
            int mid = (low + high) / 2;

            // Case 1: Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Case 2: Target is in the right half
            else if (target > nums[mid]) {
                low = mid + 1;
            }

            // Case 3: Target is in the left half
            else {
                high = mid - 1;
            }
        }

        // Target not found
        return -1;
    }
}
