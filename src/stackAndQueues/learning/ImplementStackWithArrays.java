package stackAndQueues.learning;

public class ImplementStackWithArrays {

    // Array to store stack elements
    private int[] stackArray;

    // Maximum capacity of stack
    private int capacity;

    // Index of current top element
    // -1 means stack is empty
    private int topIndex;

    // Constructor with custom size
    public ImplementStackWithArrays(int size) {

        capacity = size;

        // Initialize array
        stackArray = new int[capacity];

        // Stack is initially empty
        topIndex = -1;
    }

    // Default constructor with capacity 1000
    public ImplementStackWithArrays() {
        this(1000);
    }

    // PUSH operation
    // Adds element to top of stack
    public void push(int x) {

        // Check for overflow
        if (topIndex >= capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        // Increment topIndex first
        topIndex++;

        // Insert element at new top position
        stackArray[topIndex] = x;
    }

    // POP operation
    // Removes and returns top element
    public int pop() {

        // Check for underflow
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        // Get top element
        int element = stackArray[topIndex];

        // Decrement topIndex
        topIndex--;

        // Return popped element
        return element;
    }

    // TOP operation
    // Returns top element without removing
    public int top() {

        // Check if stack is empty
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        // Return current top element
        return stackArray[topIndex];
    }

    // Check if stack is empty
    public boolean isEmpty() {

        return topIndex == -1;
    }

    // Returns current size of stack
    public int size() {

        return topIndex + 1;
    }

}
