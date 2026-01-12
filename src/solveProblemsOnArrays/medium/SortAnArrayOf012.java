package solveProblemsOnArrays.medium;

public class SortAnArrayOf012 {

    /**
     * Sorts an array containing only 0s, 1s, and 2s using
     * the Dutch National Flag algorithm.
     *
     * @param nums the input array to be sorted in-place
     */
    public void sortZeroOneTwo(int[] nums) {

        // Pointer for the next position of 0
        int low = 0;

        // Pointer for current element being examined
        int mid = 0;

        // Pointer for the next position of 2
        int high = nums.length - 1;

        // Process elements until mid crosses high
        while (mid <= high) {

            // Case 1: current element is 0
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }

            // Case 2: current element is 1
            else if (nums[mid] == 1) {
                mid++;
            }

            // Case 3: current element is 2
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    /**
     * Utility method to swap two elements in the array.
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
