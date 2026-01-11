package importantSortingTechniques.sortingI;

public class BubbleSort {

    // Bubble sort function
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop - for passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop - for comparisons
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps occurred → array is sorted
            if (!swapped) {
                break;
            }
        }
    }

}