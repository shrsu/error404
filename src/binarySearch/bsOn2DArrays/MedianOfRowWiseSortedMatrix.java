package binarySearch.bsOn2DArrays;

public class MedianOfRowWiseSortedMatrix {

    /**
     * Counts the number of elements in a sorted row
     * that are less than or equal to the given value.
     * Uses binary search (upper bound).
     */
    int countLessEqual(int[] row, int target) {
        int low = 0;
        int high = row.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    /**
     * Finds the median of a row-wise sorted matrix.
     */
    int findMedian(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Initialize min and max values
        int low = matrix[0][0];
        int high = matrix[0][cols - 1];

        for (int i = 1; i < rows; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][cols - 1]);
        }

        int requiredCount = (rows * cols + 1) / 2;

        // Binary search on the value range
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            // Count elements <= mid
            for (int i = 0; i < rows; i++) {
                count += countLessEqual(matrix[i], mid);
            }

            if (count < requiredCount) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // low is the median
        return low;
    }
}
