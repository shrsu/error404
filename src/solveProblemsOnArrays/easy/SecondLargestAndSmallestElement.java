package solveProblemsOnArrays.easy;

public class SecondLargestAndSmallestElement {

    // Function to find the second smallest element in the array
    public static int secondSmallest(int[] arr, int n) {
        // Edge case: if the array has fewer than 2 elements
        if (n < 2)
            return -1;

        int smallest = Integer.MAX_VALUE;
        int second_smallest = Integer.MAX_VALUE;

        // Loop through the array to find the second smallest element
        for (int i = 0; i < n; i++) {
            // Update the smallest and second smallest values
            if (arr[i] < smallest) {
                second_smallest = smallest;
                smallest = arr[i];
            }
            else if (arr[i] < second_smallest && arr[i] != smallest) {
                second_smallest = arr[i];
            }
        }
        return second_smallest; // Return the second smallest element
    }

    // Function to find the second largest element in the array
    public static int secondLargest(int[] arr, int n) {
        // Edge case: if the array has fewer than 2 elements
        if (n < 2)
            return -1;

        int largest = Integer.MIN_VALUE, second_largest = Integer.MIN_VALUE;

        // Loop through the array to find the second largest element
        for (int i = 0; i < n; i++) {
            // Update the largest and second largest values
            if (arr[i] > largest) {
                second_largest = largest;
                largest = arr[i];
            }
            else if (arr[i] > second_largest && arr[i] != largest) {
                second_largest = arr[i];
            }
        }
        return second_largest; // Return the second largest element
    }
}