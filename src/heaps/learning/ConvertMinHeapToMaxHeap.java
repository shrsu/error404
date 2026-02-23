package heaps.learning;

public class ConvertMinHeapToMaxHeap {

    /**
     * Converts a Min Heap array into a Max Heap array
     *
     * @param nums the heap array
     */
    public void convertToMaxHeap(int[] nums) {

        int n = nums.length;

        // Start from last non-leaf node and move upward
        for (int i = (n / 2) - 1; i >= 0; i--) {

            // Fix heap property at each index
            maxHeapify(nums, n, i);
        }
    }


    /**
     * Ensures subtree rooted at index i satisfies max heap property
     *
     * @param nums heap array
     * @param n    size of heap
     * @param i    current index
     */
    private void maxHeapify(int[] nums, int n, int i) {

        // Assume current index is largest
        int largest = i;

        // Calculate left child index
        int left = 2 * i + 1;

        // Calculate right child index
        int right = 2 * i + 2;


        // Check if left child exists and is greater than current largest
        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }


        // Check if right child exists and is greater than current largest
        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }


        // If largest is not parent, swap and heapify again
        if (largest != i) {

            // Swap parent and largest child
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;

            // Recursively fix affected subtree
            maxHeapify(nums, n, largest);
        }
    }
}
