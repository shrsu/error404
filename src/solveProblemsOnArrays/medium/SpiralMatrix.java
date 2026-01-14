package solveProblemsOnArrays.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * Returns all elements of the given matrix in spiral order.
     *
     * Time:  O(m * n) — every element is visited once.
     * Space: O(1) extra space (output list does not count towards extra space requirement).
     *
     * @param matrix the input m x n matrix
     * @return list of integers in spiral order
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Traverse top row from left to right
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++; // shrink top boundary

            // Traverse right column from top to bottom
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--; // shrink right boundary

            // Traverse bottom row from right to left, if still within rows
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--; // shrink bottom boundary
            }

            // Traverse left column from bottom to top, if still within columns
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++; // shrink left boundary
            }
        }

        return result;
    }
}

