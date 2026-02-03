package binarySearch.bsOn2DArrays;

public class FindPeakElementIn2DMatrix {

    /**
     * Returns the row index of the maximum element in column 'col'.
     *
     * Scans all rows once for the given column.
     *
     * @param mat matrix
     * @param col column index
     * @return row index that contains the maximum value in column 'col'
     */
    private int maxRowInColumn(int[][] mat, int col) {
        int n = mat.length;
        int maxRow = 0;
        int maxVal = mat[0][col];

        for (int i = 1; i < n; i++) {
            if (mat[i][col] > maxVal) {
                maxVal = mat[i][col];
                maxRow = i;
            }
        }
        return maxRow;
    }

    /**
     * Finds any peak in the 2D matrix using binary search over columns.
     *
     * Complexity: O(m * log n) where m = number of rows, n = number of columns.
     *
     * @param mat input matrix (at least 1x1)
     * @return int[] of size 2 containing [row, col] of any peak element
     */
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;         // number of rows
        int m = mat[0].length;      // number of columns

        int low = 0;
        int high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // find row with max element in column mid
            int row = maxRowInColumn(mat, mid);

            int val = mat[row][mid];
            int left = (mid - 1 >= 0) ? mat[row][mid - 1] : Integer.MIN_VALUE;
            int right = (mid + 1 < m) ? mat[row][mid + 1] : Integer.MIN_VALUE;

            // if current is greater than both horizontal neighbors, it's a peak
            if (val > left && val > right) {
                return new int[] { row, mid };
            }

            // if left neighbor is larger, move search to left half
            if (left > val) {
                high = mid - 1;
            } else { // right neighbor is larger, move to right half
                low = mid + 1;
            }
        }

        // theoretically unreachable because a peak must exist,
        // but return a placeholder to satisfy method signature
        return new int[] { -1, -1 };
    }
}
