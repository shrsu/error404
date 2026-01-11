package solveProblemsOnArrays.easy;

public class CheckIfArrayIsSorted {
    // Function to check if the array is sorted
    public boolean isSorted(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1])  // If any element is smaller than the previous one, return false
                return false;
        }
        return true;  // Return true if the array is sorted
    }
}
