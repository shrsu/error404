package binarySearch.bsOn1DArrays;

public class SearchInsertPosition {

    // Returns the index if target is found,
    // otherwise returns the index where it should be inserted
    public int searchInsert(int[] arr, int target) {

        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = n;   // Default insertion position

        // Binary search loop
        while (low <= high) {

            // Calculate middle index
            int mid = (low + high) / 2;

            // Target can be at mid or to the left
            if (arr[mid] >= target) {
                ans = mid;          // Possible answer
                high = mid - 1;     // Search left half
            }
            // Target must be to the right
            else {
                low = mid + 1;      // Search right half
            }
        }

        return ans;
    }
}
