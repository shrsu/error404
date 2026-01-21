package binarySearch.bsOn1DArrays;

public class CountOccurrencesSortedArray {

    // Finds the first occurrence of k in the array
    public static int firstOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int first = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k) {
                first = mid;        // possible answer
                high = mid - 1;     // search left for earlier occurrence
            } else if (arr[mid] < k) {
                low = mid + 1;      // search right
            } else {
                high = mid - 1;     // search left
            }
        }
        return first;
    }

    // Finds the last occurrence of k in the array
    public static int lastOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int last = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k) {
                last = mid;         // possible answer
                low = mid + 1;      // search right for later occurrence
            } else if (arr[mid] < k) {
                low = mid + 1;      // search right
            } else {
                high = mid - 1;     // search left
            }
        }
        return last;
    }

    // Returns both first and last positions of k
    public static int[] firstAndLastPosition(int[] arr, int n, int k) {
        int first = firstOccurrence(arr, n, k);
        if (first == -1) {
            return new int[] { -1, -1 };
        }

        int last = lastOccurrence(arr, n, k);
        return new int[] { first, last };
    }

    // Returns the total count of x in the array
    public static int count(int[] arr, int n, int x) {
        int[] positions = firstAndLastPosition(arr, n, x);

        if (positions[0] == -1) {
            return 0;   // element not found
        }

        return positions[1] - positions[0] + 1;
    }
}
