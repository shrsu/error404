package solveProblemsOnArrays.hard;

public class ReversePairs {

    /**
     * Entry point: returns the number of reverse pairs in the array.
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * Modified merge sort that returns the number of reverse pairs
     * in nums[low..high].
     */
    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;
        int count = 0;

        // count reverse pairs in left and right halves
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);

        // count cross reverse pairs
        count += countPairs(nums, low, mid, high);

        // merge the two sorted halves
        merge(nums, low, mid, high);

        return count;
    }

    /**
     * Counts reverse pairs (i, j) such that:
     * low <= i <= mid < j <= high
     * nums[i] > 2 * nums[j]
     *
     * Both halves are already sorted.
     */
    public int countPairs(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int cnt = 0;

        while (left <= mid && right <= high) {
            // use long to avoid integer overflow
            if ((long) arr[left] > 2L * arr[right]) {
                // all elements from left to mid form valid pairs
                cnt += (mid - left) + 1;
                right++;
            } else {
                // move left to try a larger value
                left++;
            }
        }

        return cnt;
    }

    /**
     * Standard merge function to merge two sorted halves:
     * nums[low..mid] and nums[mid+1..high].
     */
    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = nums[left++];
        }

        while (right <= high) {
            temp[k++] = nums[right++];
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp[i - low];
        }
    }
}

