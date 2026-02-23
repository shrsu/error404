package stackAndQueues.learning;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    // Single queue used to implement stack
    private Queue<Integer> q;

    // Constructor
    public ImplementStackUsingQueue() {
        // Initialize queue
        q = new LinkedList<>();
    }

    // PUSH operation
    // Adds element to stack
    public void push(int x) {
        // Step 1: Get current size of queue
        int size = q.size();
        // Step 2: Add new element
        q.add(x);
        // Step 3: Rotate all previous elements behind new element
        // This makes new element appear at front
        for (int i = 0; i < size; i++) {
            // Remove front element
            int front = q.poll();
            // Add it to rear
            q.add(front);
        }
    }

    // POP operation
    // Removes and returns top element
    public int pop() {
        // Check if empty
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        // Remove and return front element
        return q.poll();
    }

    // TOP operation
    // Returns top element without removing
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.peek();
    }

    // Checks if stack is empty
    public boolean isEmpty() {
        return q.isEmpty();
    }

    // Returns current size
    public int size() {
        return q.size();
    }
}
