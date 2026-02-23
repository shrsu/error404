package stackAndQueues.learning;

public class ImplementQueueUsingLinkedList {

    // Node class representing each element
    private static class Node {
        int val;      // Value stored in node
        Node next;    // Pointer to next node

        // Constructor
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Pointer to front of queue
    private Node front;
    // Pointer to rear of queue
    private Node rear;
    // Tracks number of elements
    private int size;

    // Constructor
    public ImplementQueueUsingLinkedList() {
        front = null;
        rear = null;
        size = 0;
    }

    // PUSH operation (enqueue)
    // Adds element to rear of queue
    public void push(int x) {
        // Create new node
        Node newNode = new Node(x);
        // If queue is empty
        if (isEmpty()) {
            // Both front and rear point to new node
            front = newNode;
            rear = newNode;
        }
        else {
            // Link new node after rear
            rear.next = newNode;
            // Move rear pointer to new node
            rear = newNode;
        }

        // Increase size
        size++;
    }

    // POP operation (dequeue)
    // Removes and returns front element
    public int pop() {
        // Check underflow condition
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        // Store front value
        int value = front.val;
        // Move front pointer to next node
        front = front.next;
        // If queue becomes empty, reset rear
        if (front == null) {
            rear = null;
        }
        // Decrease size
        size--;
        return value;
    }

    // PEEK operation
    // Returns front element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.val;
    }

    // Checks if queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Returns size of queue
    public int size() {
        return size;
    }
}