package linkedLists.mediumProblemsOfLL;

public class MiddleOfLinkedList {

    // Node class represents a single node in the linked list
    static class Node {
        int data;      // Value stored in the node
        Node next;     // Reference to the next node

        // Constructor with data and next node
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        // Constructor with only data
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node findMiddle(Node head) {
        // Slow pointer moves one step at a time
        Node slow = head;

        // Fast pointer moves two steps at a time
        Node fast = head;

        // Traverse until fast reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow by 1
            fast = fast.next.next;    // Move fast by 2
        }

        // Slow now points to the middle node
        return slow;
    }
}
