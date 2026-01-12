package solveProblemsOnArrays.medium;

/**
 * Boyer–Moore Voting Algorithm to find the majority element.
 *
 * Runtime: O(n)
 * Space: O(1)
 */
public class MajorityElementBoyerMooreVotingAlgorithm {

    /**
     * Returns the majority element in the array.
     *
     * @param nums input array (majority element guaranteed to exist)
     * @return majority element
     */
    public int majorityElement(int[] nums) {

        int count = 0;
        int candidate = 0;

        // First pass: find potential majority candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Majority element is guaranteed to exist
        return candidate;
    }
}

