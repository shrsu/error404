package binarySearch.bsOnAnswers;

public class KthMissingPositiveNumber {

    /**
     * Brute-force method to find the k-th missing positive integer.
     * <p>
     * Time: O(N)
     * Space: O(1)
     *
     * @param arr sorted array of distinct positive integers
     * @param k   the 1-based missing index to find
     * @return the k-th missing positive integer
     */
    public int missingKBruteForce(int[] arr, int k) {
        for (int num : arr) {
            if (num <= k) {
                // num occupies one of the first k positive integers,
                // so the k-th missing must be shifted by 1.
                k++;
            } else {
                // Since arr is strictly increasing, once num > k we can stop.
                break;
            }
        }
        return k;
    }

    /**
     * Binary-search method to find the k-th missing positive integer.
     * <p>
     * Time: O(log N)
     * Space: O(1)
     *
     * @param arr sorted array of distinct positive integers
     * @param k   the 1-based missing index to find
     * @return the k-th missing positive integer
     */
    public int missingKBinarySearch(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        // Find first index 'low' where missing(arr[low]) >= k
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1); // numbers missing before arr[mid]

            if (missing < k) {
                low = mid + 1; // need more missing numbers -> move right
            } else {
                high = mid - 1; // missing >= k -> move left to find first such index
            }
        }

        // 'low' is the count of elements with missing < k.
        // The k-th missing will be k + low.
        return k + low;
    }
}

