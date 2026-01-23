package binarySearch.bsOnAnswers;

public class FindNthRoot {

    /**
     * Finds the N-th root of M using binary search.
     *
     * @param n the root to be found
     * @param m the number whose N-th root is required
     * @return the N-th root of M if it exists, otherwise -1
     */
    public int nthRoot(int n, int m) {

        int low = 1;
        int high = m;

        // Binary search over the possible answer space
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Compute mid^n safely
            long value = 1;
            for (int i = 0; i < n; i++) {
                value *= mid;

                // Early stopping to avoid overflow
                if (value > m) {
                    break;
                }
            }

            // Compare mid^n with m
            if (value == m) {
                return mid;
            } else if (value < m) {
                low = mid + 1;   // Search right half
            } else {
                high = mid - 1;  // Search left half
            }
        }

        // No integer N-th root found
        return -1;
    }
}
