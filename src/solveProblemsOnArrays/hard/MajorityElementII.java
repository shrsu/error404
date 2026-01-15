package solveProblemsOnArrays.hard;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    /**
     * Returns all elements that appear more than floor(n/3) times.
     * Uses the Boyer–Moore majority vote extension for k = 3 (at most 2 candidates).
     */
    public List<Integer> majorityElementTwo(int[] nums) {
        int n = nums.length;

        // Candidate values and their counts
        int el1 = 0, el2 = 1; // initialize to different values to avoid accidental equality
        int cnt1 = 0, cnt2 = 0;

        // 1st pass: find up to two candidates
        for (int num : nums) {
            if (num == el1) {
                // current number matches candidate 1
                cnt1++;
            } else if (num == el2) {
                // current number matches candidate 2
                cnt2++;
            } else if (cnt1 == 0) {
                // take current number as candidate 1
                el1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                // take current number as candidate 2
                el2 = num;
                cnt2 = 1;
            } else {
                // current number is different from both candidates: decrease both counts
                cnt1--;
                cnt2--;
            }
        }

        // 2nd pass: verify actual counts of the candidates
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == el1) cnt1++;
            else if (num == el2) cnt2++;
        }

        // Collect results: element must appear strictly more than floor(n/3) times
        List<Integer> result = new ArrayList<>();
        int threshold = n / 3; // floor(n/3)
        if (cnt1 > threshold) result.add(el1);
        if (cnt2 > threshold) result.add(el2);

        return result;
    }
}
