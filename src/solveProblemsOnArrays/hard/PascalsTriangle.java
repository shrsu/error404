package solveProblemsOnArrays.hard;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    // Generates the first numRows of Pascal's Triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);

            for (int j = 0; j <= i; j++) {
                // First and last elements are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Sum of the two elements directly above
                    List<Integer> prevRow = result.get(i - 1);
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }
            }

            result.add(row);
        }

        return result;
    }

    public List<Long> getNthRow(int N) {
        List<Long> row = new ArrayList<>();

        // First value is always 1
        long value = 1;
        row.add(value);

        // Compute remaining values using the binomial coefficient formula
        for (int k = 1; k < N; k++) {
            value = value * (N - k) / k;
            row.add(value);
        }

        return row;
    }

}
