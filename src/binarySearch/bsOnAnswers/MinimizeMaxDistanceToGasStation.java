package binarySearch.bsOnAnswers;

import java.util.PriorityQueue;

public class MinimizeMaxDistanceToGasStation {

    /* =========================================================
       BRUTE FORCE APPROACH
       Time Complexity: O(k * n)
       Space Complexity: O(n)
       ========================================================= */
    public double minimiseMaxDistanceBruteForce(int[] arr, int k) {
        int n = arr.length;

        // howMany[i] = number of gas stations added between arr[i] and arr[i+1]
        int[] howMany = new int[n - 1];

        // Place k gas stations
        for (int gasStations = 0; gasStations < k; gasStations++) {
            double maxSection = -1;
            int maxIndex = -1;

            // Find the segment with the maximum current distance
            for (int i = 0; i < n - 1; i++) {
                double segmentLength =
                        (arr[i + 1] - arr[i]) / (howMany[i] + 1.0);

                if (segmentLength > maxSection) {
                    maxSection = segmentLength;
                    maxIndex = i;
                }
            }

            // Place one gas station in the selected segment
            howMany[maxIndex]++;
        }

        // Find the final maximum distance
        double answer = 0;
        for (int i = 0; i < n - 1; i++) {
            double segmentLength =
                    (arr[i + 1] - arr[i]) / (howMany[i] + 1.0);
            answer = Math.max(answer, segmentLength);
        }

        return answer;
    }

    /* =========================================================
       BETTER APPROACH (PRIORITY QUEUE)
       Time Complexity: O((n + k) log n)
       Space Complexity: O(n)
       ========================================================= */
    public double minimiseMaxDistanceUsingPQ(int[] arr, int k) {
        int n = arr.length;

        int[] howMany = new int[n - 1];

        // Max heap storing the current maximum distance of each segment
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b.distance, a.distance)
        );

        // Initialize heap with initial segments
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(arr[i + 1] - arr[i], i));
        }

        // Place k gas stations
        for (int i = 0; i < k; i++) {
            Pair top = pq.poll();
            int idx = top.index;

            howMany[idx]++;

            double totalDist = arr[idx + 1] - arr[idx];
            double newDist = totalDist / (howMany[idx] + 1.0);

            pq.add(new Pair(newDist, idx));
        }

        return pq.peek().distance;
    }

    /* =========================================================
       OPTIMAL APPROACH (BINARY SEARCH)
       Time Complexity: O(n log(maxDistance))
       Space Complexity: O(1)
       ========================================================= */
    public double minimiseMaxDistanceBinarySearch(int[] arr, int k) {
        double low = 0;
        double high = 0;

        // Find the maximum initial gap
        for (int i = 0; i < arr.length - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }

        double epsilon = 1e-6;

        while (high - low > epsilon) {
            double mid = (low + high) / 2.0;

            int required = numberOfGasStationsRequired(mid, arr);

            if (required > k) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return high;
    }

    /* =========================================================
       HELPER METHOD FOR BINARY SEARCH
       ========================================================= */
    private int numberOfGasStationsRequired(double dist, int[] arr) {
        int count = 0;

        for (int i = 1; i < arr.length; i++) {
            double gap = arr[i] - arr[i - 1];
            int stations = (int) (gap / dist);

            // If gap is exactly divisible by dist, reduce one station
            if (gap == stations * dist) {
                stations--;
            }

            count += stations;
        }

        return count;
    }

    /* =========================================================
       HELPER CLASS FOR PRIORITY QUEUE APPROACH
       ========================================================= */
    private static class Pair {
        double distance;
        int index;

        Pair(double distance, int index) {
            this.distance = distance;
            this.index = index;
        }
    }
}
