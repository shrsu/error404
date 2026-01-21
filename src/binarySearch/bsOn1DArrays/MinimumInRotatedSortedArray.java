package binarySearch.bsOn1DArrays;

public class MinimumInRotatedSortedArray {

    /**
     * Finds the minimum element in a rotated sorted array
     * using binary search.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        // Perform binary search
        while (low < high) {

            int mid = low + (high - low) / 2;

            // If middle element is greater than the rightmost element,
            // the minimum lies in the right half
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
            // Otherwise, the minimum lies in the left half (including mid)
            else {
                high = mid;
            }
        }

        // low points to the minimum element
        return nums[low];
    }
}
