package solveProblemsOnArrays.medium;

public class RotateImageBy90Degree {

    /**
     * Rotates the given n x n matrix by 90 degrees clockwise in-place.
     *
     * @param matrix the input square matrix
     */
    public void rotateClockwise(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        // Swap elements across the main diagonal
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        // This finalizes the 90-degree clockwise rotation
        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }
    }

    /**
     * Reverses a single row of the matrix in-place.
     *
     * @param row the row to reverse
     */
    private void reverseRow(int[] row) {
        int left = 0;
        int right = row.length - 1;

        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}
