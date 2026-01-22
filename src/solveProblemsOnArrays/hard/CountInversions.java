package solveProblemsOnArrays.hard;

public class CountInversions {

    /**
     * Merges two sorted subarrays of arr and counts cross inversions.
     *
     * Left subarray:  arr[low ... mid]
     * Right subarray: arr[mid+1 ... high]
     */
    private int merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;       // pointer for left subarray
        int right = mid + 1;  // pointer for right subarray
        int k = 0;            // pointer for temp array

        int inversions = 0;

        // Merge while counting inversions
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                // All remaining elements in left subarray are greater
                inversions += (mid - left + 1);
            }
        }

        // Copy remaining elements from left subarray
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // Copy remaining elements from right subarray
        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // Copy merged result back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        return inversions;
    }

    /**
     * Recursive merge sort function that returns inversion count.
     */
    private int mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            return 0;
        }

        int mid = (low + high) / 2;
        int inversions = 0;

        // Count inversions in left half
        inversions += mergeSort(arr, low, mid);

        // Count inversions in right half
        inversions += mergeSort(arr, mid + 1, high);

        // Count inversions during merge
        inversions += merge(arr, low, mid, high);

        return inversions;
    }

    /**
     * Public API to get number of inversions in the array.
     */
    public int numberOfInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }
}

