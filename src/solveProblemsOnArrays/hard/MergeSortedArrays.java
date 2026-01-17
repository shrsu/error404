package solveProblemsOnArrays.hard;

public class MergeSortedArrays {

    /**
     * Merges nums2 into nums1 in-place so that nums1 becomes sorted.
     *
     * @param nums1 destination array with extra space
     * @param m     number of valid elements in nums1
     * @param nums2 source array
     * @param n     number of elements in nums2
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Pointer to last valid element in nums1
        int i = m - 1;

        // Pointer to last element in nums2
        int j = n - 1;

        // Pointer to last position in nums1 (including extra space)
        int k = m + n - 1;

        // Merge from the back to avoid shifting elements
        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // Copy any remaining elements from nums2
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }

        // Remaining nums1 elements are already in correct position
    }
}

