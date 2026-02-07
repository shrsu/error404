package linkedLists.mediumProblemsOfLL;

public class DetectLoopInLinkedList {

    // Definition for singly-linked list node
    class Node {
        int data;      // Value stored in the node
        Node next;     // Reference to the next node

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to detect a cycle in the linked list
    public boolean detectLoop(Node head) {

        // Initialize slow and fast pointers
        Node slow = head;
        Node fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {

            // Move slow by one step
            slow = slow.next;

            // Move fast by two steps
            fast = fast.next.next;

            // If both pointers meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // Fast reached the end, no cycle
        return false;
    }
}
