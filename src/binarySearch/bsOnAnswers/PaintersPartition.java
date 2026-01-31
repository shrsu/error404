package binarySearch.bsOnAnswers;

import java.util.Arrays;

public class PaintersPartition {

    /**
     * Returns the number of painters required if each painter
     * can paint at most 'time' units.
     */
    public int countPainters(int[] boards, int time) {
        int painters = 1;
        int paintedUnits = 0;

        for (int board : boards) {
            // If current painter can paint this board within 'time'
            if (paintedUnits + board <= time) {
                paintedUnits += board;
            } else {
                // Assign board to a new painter
                painters++;
                paintedUnits = board;
            }
        }

        return painters;
    }

    /**
     * Uses binary search to find the minimum time required
     * to paint all boards using k painters.
     */
    public int findLargestMinDistance(int[] boards, int k) {
        int low = Arrays.stream(boards).max().getAsInt(); // Minimum possible time
        int high = Arrays.stream(boards).sum();           // Maximum possible time
        int result = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            int painters = countPainters(boards, mid);

            if (painters > k) {
                // Time is too small, need more painters
                low = mid + 1;
            } else {
                // Valid time, try to minimize it
                result = mid;
                high = mid - 1;
            }
        }

        return result;
    }
}
