package stackAndQueues.learning;

public class ImplementStackUsingLinkedList {
    // Node class representing each element
    private static class Node {
        int val;       // Value stored in node
        Node next;     // Pointer to next node

        // Constructor
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Head represents top of stack
    private Node head;
    // Tracks number of elements
    private int size;

    // Constructor
    public ImplementStackUsingLinkedList() {
        head = null;
        size = 0;
    }

    // PUSH operation
    // Adds element to top of stack
    public void push(int x) {
        // Create new node
        Node newNode = new Node(x);
        // New node points to current head
        newNode.next = head;
        // Update head to new node
        head = newNode;
        // Increase size
        size++;
    }

    // POP operation
    // Removes and returns top element
    public int pop() {
        // Check underflow condition
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        // Store top value
        int value = head.val;
        // Move head to next node
        head = head.next;
        // Decrease size
        size--;
        return value;
    }

    // TOP operation
    // Returns top element without removing
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return head.val;
    }

    // Checks if stack is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Returns size of stack
    public int size() {
        return size;
    }

}
