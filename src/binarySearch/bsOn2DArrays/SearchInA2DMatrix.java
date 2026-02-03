package binarySearch.bsOn2DArrays;

public class SearchInA2DMatrix {

    /**
     * Search target in a 2D matrix with the given properties:
     * - each row sorted in non-decreasing order
     * - first integer of a row > last integer of previous row
     *
     * Time: O(log(rows * cols))
     * Space: O(1)
     *
     * @param matrix the 2D integer matrix
     * @param target the integer to search for
     * @return true if target exists in matrix, otherwise false
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // Guard: empty matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;     // avoid potential overflow
            int r = mid / cols;                  // map to row
            int c = mid % cols;                  // map to column
            int val = matrix[r][c];

            if (val == target) {
                return true;
            } else if (val < target) {
                low = mid + 1;                  // search right half
            } else {
                high = mid - 1;                 // search left half
            }
        }

        return false; // target not found
    }
}
