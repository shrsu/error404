package binarySearch.bsOn1DArrays;

public class FindPeakElement {

    /**
     * Finds the index of any peak element using binary search.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findPeakElement(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        // Binary search to locate a peak
        while (low < high) {

            int mid = low + (high - low) / 2;

            // If current element is greater than the next,
            // a peak exists in the left half (including mid)
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            }
            // Otherwise, a peak exists in the right half
            else {
                low = mid + 1;
            }
        }

        // low == high points to a peak element
        return low;
    }
}
