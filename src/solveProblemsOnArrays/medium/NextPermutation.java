package solveProblemsOnArrays.medium;

public class NextPermutation {

    // Rearranges nums into the next lexicographical permutation
    public void nextPermutation(int[] nums) {
        int index = -1;

        // Step 1: Find the first index from the end where nums[i] < nums[i + 1]
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: If no such index exists, reverse the entire array
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // Step 3: Find the element just larger than nums[index] and swap
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        // Step 4: Reverse the subarray to the right of index
        reverse(nums, index + 1, nums.length - 1);
    }

    // Reverses elements in the array between start and end indices
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    // Swaps two elements in the array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

