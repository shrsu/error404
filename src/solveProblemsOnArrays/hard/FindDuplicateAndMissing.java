package solveProblemsOnArrays.hard;

import java.util.*;

/**
 * FindDuplicateAndMissing
 *
 * Provides two methods to find the duplicate (A) and missing (B) numbers in an array
 * of length n containing numbers from 1..n with exactly one duplicate and one missing.
 *
 * Both methods return an int[] { duplicate, missing }.
 */
public class FindDuplicateAndMissing {

    /**
     * Mathematical method.
     *
     * Uses:
     *   S  = sum(nums)
     *   SN = sum(1..n) = n*(n+1)/2
     *   S2 = sum(nums^2)
     *   S2N = sum(1^2..n^2) = n*(n+1)*(2n+1)/6
     *
     * Let X = duplicate, Y = missing.
     *   val1 = S - SN = X - Y
     *   val2 = S2 - S2N = X^2 - Y^2 = (X - Y)*(X + Y)
     * => X + Y = val2 / val1
     * Solve for X and Y.
     *
     * Time: O(n)   Space: O(1)
     *
     * @param nums input array of length n
     * @return array {duplicate, missing}
     */
    public int[] findUsingMath(int[] nums) {
        int n = nums.length;

        // Expected sums for 1..n (use long to avoid overflow)
        long expectedSum = (long) n * (n + 1) / 2L;
        long expectedSumSq = (long) n * (n + 1) * (2L * n + 1) / 6L;

        long actualSum = 0L;
        long actualSumSq = 0L;
        for (int v : nums) {
            actualSum += v;
            actualSumSq += (long) v * (long) v;
        }

        long diff = actualSum - expectedSum;        // X - Y
        long diffSq = actualSumSq - expectedSumSq; // X^2 - Y^2

        // X + Y = diffSq / diff  (diff is guaranteed non-zero because X != Y)
        long sumXY = diffSq / diff;

        long X = (diff + sumXY) / 2; // duplicate
        long Y = X - diff;           // missing

        return new int[]{(int) X, (int) Y};
    }

    /**
     * Bitwise XOR method.
     *
     * Steps:
     * 1. Compute xr = XOR of all array elements and numbers 1..n. Result is X ^ Y.
     * 2. Find a set bit (rightmost) in xr to partition numbers into two groups.
     * 3. XOR elements and 1..n separately by that bit to obtain two candidates.
     * 4. Determine which candidate is duplicate by counting occurrences in the array.
     *
     * Time: O(n)   Space: O(1)
     *
     * @param nums input array of length n
     * @return array {duplicate, missing}
     */
    public int[] findUsingXor(int[] nums) {
        int n = nums.length;

        // XOR of all elements and 1..n yields X ^ Y
        int xr = 0;
        for (int i = 0; i < n; i++) {
            xr ^= nums[i];
            xr ^= (i + 1);
        }

        // Get rightmost set bit (a mask with only that bit set)
        int mask = xr & -xr; // same as xr & ~(xr - 1)

        int group1 = 0; // XOR of numbers having the bit set
        int group2 = 0; // XOR of numbers not having the bit set

        // Partition array elements
        for (int v : nums) {
            if ((v & mask) != 0) group1 ^= v;
            else group2 ^= v;
        }

        // Partition 1..n
        for (int i = 1; i <= n; i++) {
            if ((i & mask) != 0) group1 ^= i;
            else group2 ^= i;
        }

        // group1 and group2 now hold X and Y in some order.
        // Determine which is the duplicate by counting occurrences.
        int candidateA = group1;
        int candidateB = group2;

        int countA = 0;
        for (int v : nums) {
            if (v == candidateA) countA++;
        }

        if (countA == 2) {
            // candidateA is the duplicate
            return new int[]{candidateA, candidateB};
        } else {
            // otherwise candidateB is the duplicate
            return new int[]{candidateB, candidateA};
        }
    }
}

