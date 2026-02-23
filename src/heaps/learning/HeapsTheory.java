package heaps.learning;

import java.util.NoSuchElementException;

/**
 * Min-Heap implementation using an array.
 * <p>
 * Supports:
 * - insert(x): add element
 * - getMin(): peek minimum element (root)
 * - extractMin(): remove + return minimum element
 * - decreaseKey(i, newVal): decrease value at index i (newVal must be <= current)
 * - delete(i): delete element at index i
 * <p>
 * Time complexities:
 * - insert, extractMin, decreaseKey, delete: O(log N)
 * - getMin: O(1)
 */
public class HeapsTheory {

    private final int[] heap;   // backing array storing heap elements
    private final int capacity; // max elements allowed
    private int size;           // current number of elements in heap

    /**
     * Create a MinHeap with a fixed capacity.
     */
    public HeapsTheory(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be > 0");
        }
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    /* -----------------------------
     * Index helper methods
     * ----------------------------- */

    // Parent index of i: (i - 1) / 2
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Left child index of i: 2*i + 1
    private int left(int i) {
        return 2 * i + 1;
    }

    // Right child index of i: 2*i + 2
    private int right(int i) {
        return 2 * i + 2;
    }

    /* -----------------------------
     * Core heap operations
     * ----------------------------- */

    /**
     * Insert a new value into the heap.
     * Steps:
     * 1) put it at the end (keeps complete tree property)
     * 2) bubble it up while min-heap property is violated
     */
    public void insert(int x) {
        if (size == capacity) {
            throw new IllegalStateException("Heap overflow: capacity reached");
        }

        // Step 1: place at the end
        heap[size] = x;
        int i = size;
        size++;

        // Step 2: bubble up (swap with parent while parent > current)
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    /**
     * Return the minimum element without removing it.
     */
    public int getMin() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap[0];
    }

    /**
     * Remove and return the minimum element (root).
     * Steps:
     * 1) store root
     * 2) move last element to root
     * 3) shrink size
     * 4) heapify down from root to restore min-heap property
     */
    public int extractMin() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }

        // If only one element, just remove and return it
        if (size == 1) {
            size--;
            return heap[0];
        }

        int min = heap[0];

        // Move last to root and reduce size
        heap[0] = heap[size - 1];
        size--;

        // Restore heap property by pushing root down
        heapifyDown(0);

        return min;
    }

    /**
     * Heapify down from index i (fix min-heap violation at i),
     * assuming subtrees are already valid heaps.
     */
    private void heapifyDown(int i) {
        while (true) {
            int li = left(i);
            int ri = right(i);

            // Assume current node is smallest initially
            int smallest = i;

            // Compare with left child
            if (li < size && heap[li] < heap[smallest]) {
                smallest = li;
            }

            // Compare with right child
            if (ri < size && heap[ri] < heap[smallest]) {
                smallest = ri;
            }

            // If i is already smallest, heap property holds
            if (smallest == i) {
                break;
            }

            // Otherwise swap and continue down
            swap(i, smallest);
            i = smallest;
        }
    }

    /**
     * Decrease the value at index i to newVal.
     * Precondition: newVal <= current heap[i]
     * <p>
     * Steps:
     * 1) update value
     * 2) bubble up while parent > current
     */
    public void decreaseKey(int i, int newVal) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
        if (newVal > heap[i]) {
            throw new IllegalArgumentException("newVal must be <= current value");
        }

        heap[i] = newVal;

        // Bubble up to restore heap property
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    /**
     * Delete element at index i.
     * Classic trick:
     * 1) decrease key to -infinity (Integer.MIN_VALUE)
     * 2) extractMin to remove it from root
     */
    public void delete(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    /* -----------------------------
     * Utility methods
     * ----------------------------- */

    private void swap(int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * Print heap array (level-order representation).
     * Note: This is NOT a sorted order; it’s the internal heap layout.
     */
    public void printHeapArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + (i + 1 == size ? "\n" : " "));
        }
    }
}