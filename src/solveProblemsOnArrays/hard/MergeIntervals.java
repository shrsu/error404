package solveProblemsOnArrays.hard;

import java.util.*;

public class MergeIntervals {

    /**
     * Merges overlapping intervals.
     *
     * @param intervals array of [start, end] pairs
     * @return list of merged non-overlapping intervals
     */
    public List<List<Integer>> merge(int[][] intervals) {

        // Sort intervals by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // List to store merged intervals
        List<List<Integer>> merged = new ArrayList<>();

        // Iterate through each interval
        for (int[] interval : intervals) {

            // If no intervals merged yet OR no overlap with last interval
            if (
                    merged.isEmpty() ||
                            merged.get(merged.size() - 1).get(1) < interval[0]
            ) {
                // Add new interval
                merged.add(Arrays.asList(interval[0], interval[1]));
            } else {
                // Overlapping intervals: merge by extending the end
                int lastIndex = merged.size() - 1;
                int currentEnd = merged.get(lastIndex).get(1);
                int mergedEnd = Math.max(currentEnd, interval[1]);

                merged.get(lastIndex).set(1, mergedEnd);
            }
        }

        return merged;
    }
}

