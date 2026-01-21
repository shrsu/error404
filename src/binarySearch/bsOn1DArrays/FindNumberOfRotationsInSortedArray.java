package binarySearch.bsOn1DArrays;

public class FindNumberOfRotationsInSortedArray {

    /**
     * Finds how many times a sorted array has been rotated.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findRotations(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        // Binary search to find the index of the smallest element
        while (low < high) {

            int mid = low + (high - low) / 2;

            // If middle element is greater than the rightmost element,
            // the rotation point lies in the right half
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            }
            // Otherwise, the rotation point is at mid or in the left half
            else {
                high = mid;
            }
        }

        // Index of the smallest element = number of rotations
        return low;
    }
}
