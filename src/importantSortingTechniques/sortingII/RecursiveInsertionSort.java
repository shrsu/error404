package importantSortingTechniques.sortingII;

public class RecursiveInsertionSort {

    // Recursive insertion sort
    static void insertionSort(int[] arr, int index) {
        // Base case: array is fully processed
        if (index == arr.length) {
            return;
        }

        // Insert arr[index] into the sorted part [0 .. index-1]
        int current = arr[index];
        int j = index - 1;

        while (j >= 0 && arr[j] > current) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = current;

        // Recurse for the next element
        insertionSort(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};

        System.out.println("Before:");
        printArray(arr);

        insertionSort(arr, 0);

        System.out.println("After:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

