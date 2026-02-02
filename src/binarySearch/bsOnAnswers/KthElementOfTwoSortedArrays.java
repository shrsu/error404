package binarySearch.bsOnAnswers;

public class KthElementOfTwoSortedArrays {

    public int kthElement(int[] a, int[] b, int k) {
        int m = a.length;
        int n = b.length;

        // Ensure 'a' is the smaller array
        if (m > n) {
            return kthElement(b, a, k);
        }

        // Total elements required on the left side
        int left = k;

        // Binary search boundaries
        int low = Math.max(0, k - n);
        int high = Math.min(k, m);

        while (low <= high) {
            int mid1 = (low + high) / 2;   // Elements from array a
            int mid2 = left - mid1;       // Elements from array b

            // Left partition values
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;

            // Right partition values
            int r1 = (mid1 < m) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n) ? b[mid2] : Integer.MAX_VALUE;

            // Correct partition found
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            // Too many elements taken from a
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            // Too few elements taken from a
            else {
                low = mid1 + 1;
            }
        }

        // Invalid input case (should not occur)
        return -1;
    }
}
