package binarySearch;

public class FloorCeilInSortedArray {

    // Finds the floor of x (largest element <= x)
    public int findFloor(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Valid floor candidate
            if (arr[mid] <= x) {
                ans = arr[mid];
                low = mid + 1;      // Try to find a larger floor
            }
            // Element too large
            else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // Finds the ceil of x (smallest element >= x)
    public int findCeil(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Valid ceil candidate
            if (arr[mid] >= x) {
                ans = arr[mid];
                high = mid - 1;     // Try to find a smaller ceil
            }
            // Element too small
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Returns both floor and ceil
    public int[] getFloorAndCeil(int[] arr, int x) {
        int floor = findFloor(arr, x);
        int ceil = findCeil(arr, x);
        return new int[]{floor, ceil};
    }
}
