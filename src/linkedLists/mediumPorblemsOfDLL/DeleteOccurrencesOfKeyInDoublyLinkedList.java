package linkedLists.mediumPorblemsOfDLL;

public class DeleteOccurrencesOfKeyInDoublyLinkedList {
    // Doubly linked list node
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * Delete all occurrences of key in a doubly linked list and return updated head.
     */
    public static Node deleteAllOccurrences(Node head, int key) {
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;                // save next because curr may be removed
            if (curr.data == key) {
                // If not the head, link prev.next -> curr.next
                if (curr.prev != null) {
                    curr.prev.next = curr.next;
                } else {
                    // curr is head -> update head
                    head = curr.next;
                }
                // If not the tail, link next.prev -> curr.prev
                if (curr.next != null) {
                    curr.next.prev = curr.prev;
                }
                // Clear pointers to help garbage collection and avoid accidental retention
                curr.prev = null;
                curr.next = null;
            }
            curr = next;
        }
        return head;
    }


}
