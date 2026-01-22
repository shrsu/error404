package solveProblemsOnArrays.hard;

public class ReversePairs {

    /**
     * Public API: returns the number of reverse pairs in the array.
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        return mergeSortCount(nums, 0, nums.length - 1);
    }

    /**
     * Recursively sorts nums[low..high] and returns the count of reverse pairs
     * contained in that range.
     */
    private int mergeSortCount(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;
        int count = 0;

        // count pairs inside left and right halves
        count += mergeSortCount(nums, low, mid);
        count += mergeSortCount(nums, mid + 1, high);

        // count cross pairs (left half element with right half element)
        count += countCrossPairs(nums, low, mid, high);

        // merge the two sorted halves
        merge(nums, low, mid, high);

        return count;
    }

    /**
     * Count number of pairs (i, j) such that low <= i <= mid < j <= high and
     * nums[i] > 2 * nums[j]. Both halves nums[low..mid] and nums[mid+1..high]
     * are already sorted.
     * <p>
     * Implementation: for each left index, advance the right pointer until the
     * condition fails; the number of valid j for current i equals
     * (right - (mid + 1)).
     */
    private int countCrossPairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;

        for (int left = low; left <= mid; left++) {
            // move right as long as nums[left] > 2 * nums[right]
            while (right <= high && (long) nums[left] > 2L * nums[right]) {
                right++;
            }
            // all indices in [mid+1, right-1] satisfy condition for this left
            cnt += (right - (mid + 1));
        }

        return cnt;
    }

    /**
     * Standard merge routine: merge two sorted subarrays
     * nums[low..mid] and nums[mid+1..high] into one sorted segment.
     */
    private void merge(int[] nums, int low, int mid, int high) {
        int n = high - low + 1;
        int[] temp = new int[n];

        int i = low;        // pointer for left half
        int j = mid + 1;    // pointer for right half
        int k = 0;          // pointer for temp

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // copy remaining elements from left half (if any)
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // copy remaining elements from right half (if any)
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        // copy merged result back into original array
        System.arraycopy(temp, 0, nums, low, n);
    }
}
