package binarySearch;

public class SingleElementInSortedArray {

    /**
     * Returns the single element that appears only once
     * in a sorted array where all other elements appear twice.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;

        // Case 1: Only one element
        if (n == 1) {
            return arr[0];
        }

        // Case 2: Unique element is at the start
        if (arr[0] != arr[1]) {
            return arr[0];
        }

        // Case 3: Unique element is at the end
        if (arr[n - 1] != arr[n - 2]) {
            return arr[n - 1];
        }

        // Binary search range (excluding boundaries)
        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If mid itself is the unique element
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }

            /*
             * mid ^ 1 gives the paired index:
             * - even mid → mid + 1
             * - odd mid  → mid - 1
             */
            if (arr[mid] == arr[mid ^ 1]) {
                // Pairing is correct, unique element lies on the right
                low = mid + 1;
            } else {
                // Pairing is broken, unique element lies on the left
                high = mid - 1;
            }
        }

        // This line is theoretically unreachable for valid input
        return -1;
    }
}
