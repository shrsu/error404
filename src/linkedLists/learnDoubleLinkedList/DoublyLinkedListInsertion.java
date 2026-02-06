package linkedLists.learnDoubleLinkedList;

public class DoublyLinkedListInsertion {

    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }

    // Insert before head
    static Node insertBeforeHead(Node head, int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        if (head != null) head.prev = newNode;
        return newNode;
    }

    // Insert before tail
    static Node insertBeforeTail(Node head, int val) {
        if (head == null || head.next == null)
            return insertBeforeHead(head, val);

        Node tail = head;
        while (tail.next != null) tail = tail.next;

        Node prev = tail.prev;
        Node newNode = new Node(val);

        newNode.prev = prev;
        newNode.next = tail;
        prev.next = newNode;
        tail.prev = newNode;

        return head;
    }

    // Insert before kth node (1-based)
    static Node insertBeforeKth(Node head, int k, int val) {
        if (k == 1) return insertBeforeHead(head, val);

        Node temp = head;
        int count = 1;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }
        if (temp == null) return head;

        Node prev = temp.prev;
        Node newNode = new Node(val);

        newNode.prev = prev;
        newNode.next = temp;
        prev.next = newNode;
        temp.prev = newNode;

        return head;
    }

    // Insert before a given node (node is not head)
    static void insertBeforeNode(Node node, int val) {
        Node prev = node.prev;
        Node newNode = new Node(val);

        newNode.prev = prev;
        newNode.next = node;
        prev.next = newNode;
        node.prev = newNode;
    }
}
