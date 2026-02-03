package binarySearch.bsOn2DArrays;

// Class to perform staircase search in a row and column wise sorted matrix
public class SearchInRowAndColumnWiseSortedMatrix {

    /**
     * Searches for the target element in the matrix.
     *
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     *
     * @param target the value to search for
     * @return true if target exists, otherwise false
     */
    public boolean searchElement(int target, int[][] matrix) {
        int n = matrix.length;        // Number of rows
        int m = matrix[0].length;     // Number of columns

        int row = 0;        // Start from first row
        int col = m - 1;    // Start from last column (top-right corner)

        // Traverse until indices go out of bounds
        while (row < n && col >= 0) {
            int current = matrix[row][col];

            if (current == target) {
                return true;          // Target found
            } else if (current < target) {
                row++;                // Move down to larger values
            } else {
                col--;                // Move left to smaller values
            }
        }

        return false; // Target not found
    }
}
