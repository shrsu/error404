package binarySearch.bsOn2DArrays;

public class FindTheRowWithMaxNumberOf1 {

    /**
     * Finds the first index where the value is greater than or equal to x.
     * This is equivalent to the lower bound operation.
     */
    public int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n; // Default if x is not found

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                ans = mid;        // Potential answer
                high = mid - 1;   // Search left part
            } else {
                low = mid + 1;    // Search right part
            }
        }
        return ans;
    }

    /**
     * Returns the index of the row with the maximum number of 1s.
     * If no 1 exists in the matrix, returns -1.
     */
    public int rowWithMax1s(int[][] matrix, int n, int m) {
        int maxCount = 0; // Maximum number of 1s found
        int rowIndex = -1;

        // Traverse each row
        for (int i = 0; i < n; i++) {
            // Number of 1s = total columns - index of first 1
            int countOnes = m - lowerBound(matrix[i], m, 1);

            // Update maximum and row index
            if (countOnes > maxCount) {
                maxCount = countOnes;
                rowIndex = i;
            }
        }
        return rowIndex;
    }
}
