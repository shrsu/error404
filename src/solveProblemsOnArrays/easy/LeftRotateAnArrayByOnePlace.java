package solveProblemsOnArrays.easy;

public class LeftRotateAnArrayByOnePlace {
    public void rotateArrayByOne(int[] nums) {
        // Store the first element in a temporary variable
        int temp = nums[0];

        // Shift elements to the left
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }

        // Place the first element at the end
        nums[nums.length - 1] = temp;
    }
}
