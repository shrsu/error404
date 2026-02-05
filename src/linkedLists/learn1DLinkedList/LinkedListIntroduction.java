package linkedLists.learn1DLinkedList;

public class LinkedListIntroduction {

    // Node definition (singly linked list)
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Convert array -> linked list. Returns head (null if array empty).
    public static Node arrayToLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            mover.next = new Node(arr[i]);
            mover = mover.next;
        }
        return head;
    }

    // Traverse and print elements on one line
    public static void traverse(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Length of the linked list
    public static int length(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Search for key in linked list
    public static boolean contains(Node head, int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    // Insert at head. Returns new head.
    public static Node insertAtHead(Node head, int value) {
        return new Node(value, head);
    }

    // Insert at tail. Returns head (unchanged if non-null).
    public static Node insertAtTail(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) return newNode;
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        return head;
    }

    // Delete first occurrence of value. Returns new head.
    public static Node deleteFirstOccurrence(Node head, int value) {
        if (head == null) return null;
        // If head needs deletion
        if (head.data == value) return head.next;
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.data == value) {
                prev.next = curr.next;
                return head;
            }
            prev = curr;
            curr = curr.next;
        }
        return head; // value not found
    }

    // Demo for all operations
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 8};

        // 1) Convert array to linked list
        Node head = arrayToLinkedList(arr);
        System.out.print("List after arrayToLinkedList: ");
        traverse(head); // 2 -> 1 -> 3 -> 8

        // 2) Length
        System.out.println("Length: " + length(head)); // 4

        // 3) Search
        System.out.println("Contains 3? " + contains(head, 3));   // true
        System.out.println("Contains 10? " + contains(head, 10)); // false

        // 4) Insert at head
        head = insertAtHead(head, 99);
        System.out.print("After insertAtHead(99): ");
        traverse(head); // 99 -> 2 -> 1 -> 3 -> 8

        // 5) Insert at tail
        head = insertAtTail(head, 55);
        System.out.print("After insertAtTail(55): ");
        traverse(head); // 99 -> 2 -> 1 -> 3 -> 8 -> 55

        // 6) Delete first occurrence
        head = deleteFirstOccurrence(head, 1);
        System.out.print("After deleteFirstOccurrence(1): ");
        traverse(head); // 99 -> 2 -> 3 -> 8 -> 55

        // 7) Delete head value
        head = deleteFirstOccurrence(head, 99);
        System.out.print("After deleteFirstOccurrence(99): ");
        traverse(head); // 2 -> 3 -> 8 -> 55

        // 8) Delete non-existing value (no change)
        head = deleteFirstOccurrence(head, 1234);
        System.out.print("After deleteFirstOccurrence(1234): ");
        traverse(head); // 2 -> 3 -> 8 -> 55

        // Final stats
        System.out.println("Final Length: " + length(head));       // 4
        System.out.println("Final Contains 55? " + contains(head, 55)); // true
    }
}
