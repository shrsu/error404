package linkedLists.mediumProblemsOfLL;

// Class containing the solution logic
public class RemoveNthNodeFromBackInLinkedList {

    // Definition for singly-linked list node
    static class Node {
        int data;
        Node next;

        // Constructor with data and next reference
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        // Constructor with data only
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Removes the Nth node from the end of the linked list
    public Node deleteNthNodeFromEnd(Node head, int n) {

        // Dummy node to handle edge cases (e.g., deleting head)
        Node dummy = new Node(0, head);

        // Initialize two pointers
        Node slow = dummy;
        Node fast = dummy;

        // Move fast pointer n + 1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Skip the target node
        slow.next = slow.next.next;

        // Return the updated head
        return dummy.next;
    }
}
