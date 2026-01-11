package importantSortingTechniques.sortingII;

public class RecursiveBubbleSort {

    static void bubbleSort(int[] arr, int n) {
        // Base case
        if (n == 1) return;

        boolean didSwap = false;

        // One pass of bubble sort
        for (int j = 0; j <= n - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                didSwap = true;
            }
        }

        // If no swaps occurred, array is already sorted
        if (!didSwap) return;

        // Recursive call for remaining array
        bubbleSort(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        bubbleSort(arr, arr.length);

        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}