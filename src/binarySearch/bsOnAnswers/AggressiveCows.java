package binarySearch.bsOnAnswers;

import java.util.Arrays;

public class AggressiveCows {

    // Checks whether it is possible to place 'cows' cows
    // such that the minimum distance between any two cows is at least 'distance'
    public boolean canPlace(int[] stalls, int cows, int distance) {
        // Place the first cow in the first stall
        int count = 1;
        int lastPlacedPosition = stalls[0];

        // Try placing the remaining cows
        for (int i = 1; i < stalls.length; i++) {
            // If the current stall is far enough from the last placed cow
            if (stalls[i] - lastPlacedPosition >= distance) {
                count++;
                lastPlacedPosition = stalls[i];
            }

            // If all cows are placed successfully
            if (count >= cows) {
                return true;
            }
        }

        // Not all cows could be placed
        return false;
    }

    // Returns the maximum possible minimum distance between any two cows
    public int aggressiveCows(int[] stalls, int cows) {
        // Sort stall positions
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int answer = 0;

        // Binary search on the distance
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if cows can be placed with at least 'mid' distance
            if (canPlace(stalls, cows, mid)) {
                answer = mid;        // Update answer
                low = mid + 1;       // Try for a larger distance
            } else {
                high = mid - 1;      // Try for a smaller distance
            }
        }

        return answer;
    }
}
