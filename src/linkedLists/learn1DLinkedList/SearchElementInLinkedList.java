package linkedLists.learn1DLinkedList;

public class SearchElementInLinkedList {

    // Node definition
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to search an element
    public static boolean searchLinkedList(Node head, int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    // Driver code
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(8);

        System.out.println(searchLinkedList(head, 3));  // true
        System.out.println(searchLinkedList(head, 10)); // false
    }
}

