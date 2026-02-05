package linkedLists.learn1DLinkedList;

public class DeletingNodeInLinkedList {

    // Node definition
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

    // 1. Delete Head
    public static Node deleteHead(Node head) {
        if (head == null) return null;
        return head.next;
    }

    // 2. Delete Tail
    public static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }

    // 3. Delete k-th Node (1-based index)
    public static Node deleteAtPosition(Node head, int k) {
        if (head == null) return null;

        // Delete head
        if (k == 1) {
            return head.next;
        }

        Node temp = head;
        Node prev = null;
        int count = 1;

        while (temp != null) {
            if (count == k) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
            count++;
        }

        return head;
    }

    // 4. Delete Node by Value (first occurrence)
    public static Node deleteByValue(Node head, int val) {
        if (head == null) return null;

        // If value is at head
        if (head.data == val) {
            return head.next;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if (temp.data == val) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    // Utility method to print list
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        Node head = new Node(3, new Node(5, new Node(8, new Node(7))));

        printList(head); // 3 -> 5 -> 8 -> 7

        head = deleteHead(head);
        printList(head); // 5 -> 8 -> 7

        head = deleteTail(head);
        printList(head); // 5 -> 8

        head = deleteAtPosition(head, 2);
        printList(head); // 5

        head = deleteByValue(head, 5);
        printList(head); // empty
    }
}
