package heaps.learning;

public class CheckIfAnArrayRepresentsMinHeap {

    /**
     * Checks whether the given array represents a valid Binary Min Heap.
     *
     * @param nums the input array representing the heap
     * @return true if valid min heap, false otherwise
     */
    public boolean isMinHeap(int[] nums) {

        // Total number of elements
        int n = nums.length;

        // Only iterate through non-leaf nodes
        // Last non-leaf node is at index (n/2) - 1
        for (int i = 0; i <= (n / 2) - 1; i++) {

            // Calculate left child index
            int left = 2 * i + 1;

            // Check if left child exists AND violates min heap property
            if (left < n && nums[i] > nums[left]) {
                return false;
            }

            // Calculate right child index
            int right = 2 * i + 2;

            // Check if right child exists AND violates min heap property
            if (right < n && nums[i] > nums[right]) {
                return false;
            }
        }

        // If no violations found, array represents a valid min heap
        return true;
    }
}
