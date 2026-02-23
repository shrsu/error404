package stackAndQueues.learning;

import java.util.Stack;

public class ImplementQueueUsingStack {
    // Stack used for push operations
    private Stack<Integer> inputStack;
    // Stack used for pop and peek operations
    private Stack<Integer> outputStack;

    // Constructor
    public ImplementQueueUsingStack() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    // PUSH operation
    // Adds element to end of queue
    public void push(int x) {
        // Always push to input stack
        inputStack.push(x);
    }

    // POP operation
    // Removes and returns front element
    public int pop() {
        // If output stack is empty, transfer elements
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                // Move elements from input to output
                outputStack.push(inputStack.pop());
            }
        }
        // If still empty, queue is empty
        if (outputStack.isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        // Pop from output stack (oldest element)
        return outputStack.pop();
    }

    // PEEK operation
    // Returns front element without removing
    public int peek() {
        // Transfer if output stack is empty
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        if (outputStack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return outputStack.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    // Returns size of queue
    public int size() {
        return inputStack.size() + outputStack.size();
    }
}
