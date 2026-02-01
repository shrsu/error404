package binarySearch.bsOnAnswers;

public class MedianOfTwoSortedArrays {

    /**
     * Linear two-pointer approach.
     * Scans through the two sorted arrays without building a merged array,
     * and captures the middle element(s) when the merged index reaches them.
     *
     * Time: O(m + n)
     * Space: O(1)
     *
     * @param nums1 first sorted array
     * @param nums2 second sorted array
     * @return median as a double
     */
    public static double medianLinear(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int total = n1 + n2;

        int mid2 = total / 2;        // index of the right middle (0-based)
        int mid1 = (total % 2 == 0) ? mid2 - 1 : mid2; // left middle for even, same as mid2 for odd

        int i = 0, j = 0, cnt = 0;
        int leftVal = 0, rightVal = 0;

        while (i < n1 || j < n2) {
            int cur;
            if (i < n1 && (j >= n2 || nums1[i] <= nums2[j])) {
                cur = nums1[i++];
            } else {
                cur = nums2[j++];
            }

            if (cnt == mid1) leftVal = cur;
            if (cnt == mid2) {
                rightVal = cur;
                break; // we have both required elements
            }
            cnt++;
        }

        if (total % 2 == 1) {
            // odd -> both mid1 and mid2 are same; rightVal holds median
            return (double) rightVal;
        } else {
            return (leftVal + rightVal) / 2.0;
        }
    }

    /**
     * Optimal binary-search partition approach.
     * Performs binary search on the smaller array to find a partition such that
     * max(lefts) <= min(rights). Then computes the median from boundary values.
     *
     * Time: O(log(min(m,n)))
     * Space: O(1)
     *
     * @param nums1 first sorted array
     * @param nums2 second sorted array
     * @return median as a double
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to minimize binary search range
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            if (left1 <= right2 && left2 <= right1) {
                // Found correct partition
                if ((m + n) % 2 == 0) {
                    int leftMax = Math.max(left1, left2);
                    int rightMin = Math.min(right1, right2);
                    return (leftMax + rightMin) / 2.0;
                } else {
                    return (double) Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                // need to move cut1 to the left
                high = cut1 - 1;
            } else {
                // left2 > right1, move cut1 to the right
                low = cut1 + 1;
            }
        }

        // Should never reach here if inputs satisfy constraints
        throw new IllegalArgumentException("Input arrays are not valid for median computation.");
    }

}

