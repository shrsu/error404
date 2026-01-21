package binarySearch.bsOn1DArrays;

public class LowerBound {

    // Finds the lower bound index of x in a sorted array
    // Returns the smallest index such that arr[index] >= x
    // If no such index exists, returns arr.length
    public int lowerBound(int[] arr, int x) {

        int low = 0;                    // Start index
        int high = arr.length - 1;      // End index
        int ans = arr.length;           // Default answer

        // Binary search loop
        while (low <= high) {

            // Calculate middle index
            int mid = (low + high) / 2;

            // If current element is a valid candidate
            if (arr[mid] >= x) {
                ans = mid;              // Store possible answer
                high = mid - 1;         // Search left half
            }
            // If current element is smaller than x
            else {
                low = mid + 1;          // Search right half
            }
        }

        return ans;  // Lower bound index
    }
}
