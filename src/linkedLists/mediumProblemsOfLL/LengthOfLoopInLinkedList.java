package linkedLists.mediumProblemsOfLL;

// Class to find the length of a loop in a linked list
public class LengthOfLoopInLinkedList {

    // Node class representing a linked list node
    static class Node {
        int data;     // value stored in the node
        Node next;    // reference to the next node

        // Constructor with data and next node
        Node(int data1, Node next1) {
            data = data1;
            next = next1;
        }

        // Constructor with only data
        Node(int data1) {
            data = data1;
            next = null;
        }
    }

    /**
     * Returns the length of the loop in the linked list.
     * If no loop exists, returns 0.
     */
    public int lengthOfLoop(Node head) {
        // Initialize slow and fast pointers
        Node slow = head;
        Node fast = head;

        // Traverse the list to detect a loop
        while (fast != null && fast.next != null) {
            slow = slow.next;           // move slow by 1
            fast = fast.next.next;     // move fast by 2

            // Loop detected
            if (slow == fast) {
                return countLoopLength(slow);
            }
        }

        // No loop found
        return 0;
    }

    /**
     * Counts the number of nodes in the loop,
     * starting from the meeting point.
     */
    private int countLoopLength(Node meetingPoint) {
        Node temp = meetingPoint;
        int length = 1;

        // Traverse the loop until we return to the meeting point
        while (temp.next != meetingPoint) {
            temp = temp.next;
            length++;
        }

        return length;
    }
}
