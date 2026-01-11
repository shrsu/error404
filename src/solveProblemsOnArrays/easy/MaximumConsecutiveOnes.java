package solveProblemsOnArrays.easy;

public class MaximumConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int count = 0;

        for(int num : nums){
            if(num == 1) count++;
            if(num == 0) count = 0;
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
