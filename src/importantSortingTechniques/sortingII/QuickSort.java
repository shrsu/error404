package importantSortingTechniques.sortingII;

public class QuickSort {

    public enum PartitionScheme {
        LOMUTO,
        HOARE
    }

    // Public entry point
    public static void quickSort(int[] arr, int low, int high, PartitionScheme scheme) {
        if (low < high) {
            if (scheme == PartitionScheme.LOMUTO) {
                int pivotIndex = lomutoPartition(arr, low, high);
                quickSort(arr, low, pivotIndex - 1, scheme);
                quickSort(arr, pivotIndex + 1, high, scheme);
            } else {
                int pivotIndex = hoarePartition(arr, low, high);
                quickSort(arr, low, pivotIndex, scheme);
                quickSort(arr, pivotIndex + 1, high, scheme);
            }
        }
    }

    /* =========================
       Lomuto Partition
       ========================= */
    private static int lomutoPartition(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int pivotIndex = medianOfThree(arr, low, mid, high);
        int pivot = arr[pivotIndex];

        swap(arr, pivotIndex, high);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    /* =========================
       Hoare Partition
       ========================= */
    private static int hoarePartition(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int pivotIndex = medianOfThree(arr, low, mid, high);
        swap(arr, pivotIndex, low);
        int pivot = arr[low];

        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                return j;
            }

            swap(arr, i, j);
        }
    }

    /* =========================
       Shared Utilities
       ========================= */
    private static int medianOfThree(int[] arr, int a, int b, int c) {
        if ((arr[a] > arr[b]) != (arr[a] > arr[c]))
            return a;
        else if ((arr[b] > arr[a]) != (arr[b] > arr[c]))
            return b;
        else
            return c;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
