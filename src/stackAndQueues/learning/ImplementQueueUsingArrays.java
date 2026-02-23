package stackAndQueues.learning;

public class ImplementQueueUsingArrays {

    // Array to store queue elements
    private int[] arr;
    // Index of front element
    private int start;
    // Index of rear element
    private int end;
    // Current number of elements
    private int currSize;
    // Maximum capacity
    private int maxSize;

    // Constructor with custom capacity
    public ImplementQueueUsingArrays(int size) {
        maxSize = size;
        arr = new int[maxSize];
        // Initialize as empty queue
        start = -1;
        end = -1;
        currSize = 0;
    }

    // Default constructor
    public ImplementQueueUsingArrays() {
        this(1000);
    }

    // PUSH operation
    // Adds element to rear of queue
    public void push(int x) {
        // Check overflow
        if (currSize == maxSize) {
            System.out.println("Queue Overflow");
            return;
        }
        // First element insertion
        if (currSize == 0) {
            start = 0;
            end = 0;
        }
        else {
            // Circular increment
            end = (end + 1) % maxSize;
        }
        // Insert element
        arr[end] = x;
        // Increase size
        currSize++;
    }

    // POP operation
    // Removes and returns front element
    public int pop() {
        // Check underflow
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        // Store front element
        int element = arr[start];
        // If only one element, reset queue
        if (currSize == 1) {
            start = -1;
            end = -1;
        }
        else {

            // Circular increment
            start = (start + 1) % maxSize;
        }
        // Decrease size
        currSize--;
        return element;
    }

    // PEEK operation
    // Returns front element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[start];
    }

    // Checks if queue is empty
    public boolean isEmpty() {
        return currSize == 0;
    }

    // Returns current size
    public int size() {
        return currSize;
    }
}
