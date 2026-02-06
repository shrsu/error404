package linkedLists.learnDoubleLinkedList;

public class DoublyLinkedListDeletion {

    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }

    // Delete head
    static Node deleteHead(Node head) {
        if (head == null || head.next == null) return null;
        Node newHead = head.next;
        newHead.prev = null;
        head.next = null;
        return newHead;
    }

    // Delete tail
    static Node deleteTail(Node head) {
        if (head == null || head.next == null) return null;

        Node tail = head;
        while (tail.next != null) tail = tail.next;

        tail.prev.next = null;
        tail.prev = null;
        return head;
    }

    // Delete kth node (1-based)
    static Node deleteKth(Node head, int k) {
        if (head == null) return null;

        Node temp = head;
        int count = 1;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }
        if (temp == null) return head;

        if (temp.prev == null && temp.next == null) return null;
        if (temp.prev == null) return deleteHead(head);
        if (temp.next == null) return deleteTail(head);

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = temp.prev = null;

        return head;
    }

    // Delete a given node (not head)
    static void deleteGivenNode(Node node) {
        if (node.next == null) {
            node.prev.next = null;
            node.prev = null;
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = node.prev = null;
    }
}
