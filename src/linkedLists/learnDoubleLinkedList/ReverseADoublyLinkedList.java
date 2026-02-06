package linkedLists.learnDoubleLinkedList;

import java.util.Stack;

public class ReverseADoublyLinkedList {

    // Doubly Linked List Node
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    /* =========================================================
       Method 1: Brute Force
       Reverse by swapping DATA using a Stack (two-pass solution)
       ========================================================= */
    public static Node reverseByDataUsingStack(Node head) {
        if (head == null) return null;

        Stack<Integer> stack = new Stack<>();
        Node current = head;

        // First pass: push all data into stack
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        // Second pass: pop data back into list
        current = head;
        while (current != null) {
            current.data = stack.pop();
            current = current.next;
        }

        return head;
    }

    /* =========================================================
       Method 2: Optimal
       Reverse by swapping LINKS (prev <-> next) in one pass
       ========================================================= */
    public static Node reverseInPlace(Node head) {
        if (head == null) return null;

        Node current = head;
        Node temp = null;

        while (current != null) {
            // swap prev and next
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            // move to next node in original order
            current = current.prev;
        }

        // temp is at the node before new head
        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }

    /* =========================================================
       Utility method (optional) to print list forward
       ========================================================= */
    public static void printForward(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

