package linkedLists.mediumPorblemsOfDLL;

public class RemoveDuplicatesFromSortedDoublyLinkedList {

    // Node class representing a doubly linked list node
    static class Node {
        int data;
        Node prev;
        Node next;

        // Constructor
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    /**
     * Removes duplicate values from a sorted doubly linked list.
     * @return head of the modified list
     */
    public Node removeDuplicates(Node head) {
        // If list is empty, return null
        if (head == null) {
            return null;
        }

        Node current = head;

        // Traverse the list
        while (current != null && current.next != null) {

            Node nextDistinct = current.next;

            // Skip all nodes with the same value as current
            while (nextDistinct != null && nextDistinct.data == current.data) {
                nextDistinct = nextDistinct.next;
            }

            // Link current node to the next distinct node
            current.next = nextDistinct;
            if (nextDistinct != null) {
                nextDistinct.prev = current;
            }

            // Move to the next node
            current = current.next;
        }

        return head;
    }
}
