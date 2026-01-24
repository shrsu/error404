package binarySearch.bsOnAnswers;

import java.util.Arrays;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        // Minimum possible speed
        int low = 1;

        // Maximum possible speed is the largest pile
        int high = Arrays.stream(piles).max().getAsInt();

        // Store the best (minimum valid) answer
        int ans = high;

        // Binary search on the answer space
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check how many hours are needed at speed = mid
            if (calculateTotalHours(piles, mid) <= h) {
                // mid is a valid speed, try to minimize it
                ans = mid;
                high = mid - 1;
            } else {
                // mid is too slow, need a higher speed
                low = mid + 1;
            }
        }

        return ans;
    }

    /**
     * Calculates total hours required to eat all piles
     * at a given eating speed.
     */
    private long calculateTotalHours(int[] piles, int speed) {
        long totalHours = 0;

        for (int pile : piles) {
            // Ceiling division: ceil(pile / speed)
            totalHours += (pile + speed - 1) / speed;
        }

        return totalHours;
    }
}
