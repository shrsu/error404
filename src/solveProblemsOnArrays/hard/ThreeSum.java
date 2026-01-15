package solveProblemsOnArrays.hard;

import java.util.*;


public class ThreeSum {
    /**
     * HashSet-based solution (deduplicated via a Set of sorted lists).
     * Time: O(n^2) in practice
     * Space: O(k + n) where k is number of unique triplets (for answer) and O(n) for the temporary set per i
     */
    public List<List<Integer>> threeSumHashSet(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> unique = new HashSet<>();

        for (int i = 0; i < n; i++) {
            // HashSet stores elements seen in the inner loop for this fixed i
            Set<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int needed = -(nums[i] + nums[j]);
                if (seen.contains(needed)) {
                    // build a sorted triplet to ensure uniqueness
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], needed);
                    Collections.sort(triplet);
                    unique.add(triplet);
                }
                // mark current nums[j] as seen for future j in this i-iteration
                seen.add(nums[j]);
            }
        }

        // convert set of triplets to list
        return new ArrayList<>(unique);
    }

    /**
     * Two-pointer optimal solution for 3-sum.
     * Sorts the array and uses two pointers to find unique triplets summing to zero.
     */
    public List<List<Integer>> threeSumTwoPointers(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate fixed elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else { // sum > 0
                    right--;
                }
            }
        }

        return ans;
    }
}

