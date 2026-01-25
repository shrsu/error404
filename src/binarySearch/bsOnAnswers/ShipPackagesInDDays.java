package binarySearch.bsOnAnswers;

import java.util.Arrays;

public class ShipPackagesInDDays {

    /**
     * Calculates the number of days needed to ship all packages
     * using a given ship capacity.
     */
    int daysNeeded(int[] weights, int capacity) {
        int days = 1;          // Start with day 1
        int currentLoad = 0;   // Current weight on the ship

        for (int weight : weights) {
            // If adding this package exceeds capacity,
            // ship it the next day
            if (currentLoad + weight > capacity) {
                days++;
                currentLoad = weight;
            } else {
                currentLoad += weight;
            }
        }
        return days;
    }

    /**
     * Returns the minimum ship capacity required
     * to ship all packages within d days.
     */
    int shipWithinDays(int[] weights, int d) {
        // Lower bound: heaviest package
        int left = Arrays.stream(weights).max().getAsInt();

        // Upper bound: sum of all packages
        int right = Arrays.stream(weights).sum();

        // Binary search for minimum valid capacity
        while (left < right) {
            int mid = left + (right - left) / 2;

            int requiredDays = daysNeeded(weights, mid);

            if (requiredDays <= d) {
                // Capacity is sufficient, try smaller one
                right = mid;
            } else {
                // Capacity is insufficient, increase it
                left = mid + 1;
            }
        }

        return left;
    }
}
