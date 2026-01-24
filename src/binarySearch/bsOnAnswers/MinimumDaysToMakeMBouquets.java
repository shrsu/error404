package binarySearch.bsOnAnswers;

public class MinimumDaysToMakeMBouquets {

    /**
     * Helper method to calculate how many bouquets can be formed
     * if we wait for 'mid' days.
     *
     * @param bloomDay Array representing bloom days of flowers
     * @param mid      The day up to which flowers are considered bloomed
     * @param k        Number of adjacent flowers required per bouquet
     * @return         Number of bouquets that can be formed
     */
    private int getNumOfBouquets(int[] bloomDay, int mid, int k) {
        int bouquets = 0;   // Total bouquets formed
        int count = 0;      // Count of consecutive bloomed flowers

        for (int i = 0; i < bloomDay.length; i++) {
            // If the flower has bloomed by day 'mid'
            if (bloomDay[i] <= mid) {
                count++;
            } else {
                // Reset if the flower has not bloomed
                count = 0;
            }

            // If we have k adjacent bloomed flowers
            if (count == k) {
                bouquets++;
                count = 0; // Reset after forming a bouquet
            }
        }

        return bouquets;
    }

    /**
     * Main method to find the minimum number of days required
     * to make 'm' bouquets.
     *
     * @param bloomDay Array representing bloom days of flowers
     * @param m        Number of bouquets required
     * @param k        Number of adjacent flowers per bouquet
     * @return         Minimum number of days, or -1 if impossible
     */
    public int minDays(int[] bloomDay, int m, int k) {

        // Early exit if not enough flowers
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        // Find minimum and maximum bloom days
        for (int day : bloomDay) {
            start = Math.min(start, day);
            end = Math.max(end, day);
        }

        int answer = -1;

        // Binary search on number of days
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if we can form at least 'm' bouquets by day 'mid'
            if (getNumOfBouquets(bloomDay, mid, k) >= m) {
                answer = mid;      // Possible answer
                end = mid - 1;     // Try to find a smaller day
            } else {
                start = mid + 1;   // Need more days
            }
        }

        return answer;
    }
}
