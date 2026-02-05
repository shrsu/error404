package linkedLists.learn1DLinkedList;

/**
 * Single Java class containing Node definition and common insertion helpers for a
 * singly linked list (all methods are 1-based where a position of 1 means "head").
 * <p>
 * Methods:
 * - insertAtHead(Node head, int val)
 * - insertAtTail(Node head, int val)
 * - insertAtPosition(Node head, int val, int k)   // 1-based position
 * - insertBeforeValue(Node head, int val, int target) // inserts before first occurrence
 * - printList(Node head)
 * <p>
 * Behavior notes:
 * - insertAtPosition treats k <= 1 as insertion at head.
 * - If insertAtPosition's k is > length+1, the list is returned unchanged.
 * - insertBeforeValue returns the original list if target not found.
 * - Methods return the (possibly new) head so callers should capture the return value.
 */
public class InsertingNodeInLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this(data, null);
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Insert at head (O(1))
    public static Node insertAtHead(Node head, int val) {
        return new Node(val, head);
    }

    // Insert at tail (O(n))
    public static Node insertAtTail(Node head, int val) {
        if (head == null) return new Node(val);
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = new Node(val);
        return head;
    }

    // Insert at k-th position (1-based). If k <= 1 => insert at head.
    // If k is greater than length+1, list is unchanged.
    public static Node insertAtPosition(Node head, int val, int k) {
        if (k <= 1) {
            return new Node(val, head);
        }
        if (head == null) {
            // only valid insertion when k == 1 (handled above)
            return head;
        }
        Node temp = head;
        int count = 1; // temp currently at position 1
        while (temp != null && count < k - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            // k is out of bounds (greater than length+1)
            return head;
        }
        Node newNode = new Node(val, temp.next);
        temp.next = newNode;
        return head;
    }

    // Insert new node with value 'val' before the first node whose data == target.
    // If target is at head, new node becomes new head. If target not found, list unchanged.
    public static Node insertBeforeValue(Node head, int val, int target) {
        if (head == null) return head;
        if (head.data == target) return new Node(val, head);

        Node temp = head;
        while (temp.next != null && temp.next.data != target) {
            temp = temp.next;
        }
        if (temp.next == null) {
            // target not found
            return head;
        }
        Node newNode = new Node(val, temp.next);
        temp.next = newNode;
        return head;
    }

    // Utility: print list (values separated by " -> ")
    public static void printList(Node head) {
        Node cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(" -> ");
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }

    // Example usage
    public static void main(String[] args) {
        Node head = null;

        // insertAtHead
        head = insertAtHead(head, 3); // 3
        head = insertAtHead(head, 2); // 2 -> 3
        head = insertAtHead(head, 1); // 1 -> 2 -> 3
        printList(head);

        // insertAtTail
        head = insertAtTail(head, 4); // 1 -> 2 -> 3 -> 4
        head = insertAtTail(head, 5); // 1 -> 2 -> 3 -> 4 -> 5
        printList(head);

        // insertAtPosition
        head = insertAtPosition(head, 9, 1); // insert at head: 9 -> 1 -> 2 -> 3 -> 4 -> 5
        head = insertAtPosition(head, 8, 3); // insert at pos 3: 9 -> 1 -> 8 -> 2 -> 3 -> 4 -> 5
        head = insertAtPosition(head, 7, 8); // insert at pos 8 (tail): ... -> 5 -> 7
        printList(head);

        // insertBeforeValue
        head = insertBeforeValue(head, 100, 2); // insert 100 before first '2'
        head = insertBeforeValue(head, 200, 9); // insert 200 before first '9' (head)
        printList(head);
    }
}
