package solveProblemsOnArrays.easy;

public class FindMissingNumberInAnArray {

    public int missingNumber(int[] nums) {
        int n = nums.length + 1; // since one number is missing

        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}

