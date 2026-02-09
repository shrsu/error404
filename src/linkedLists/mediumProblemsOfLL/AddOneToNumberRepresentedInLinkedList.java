package linkedLists.mediumProblemsOfLL;

public class AddOneToNumberRepresentedInLinkedList {

    /**
     * Node of singly linked list.
     * Each node stores a single digit.
     */
    static class Node {
        int data;      // digit value (0–9)
        Node next;     // reference to next node

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // =========================================================
    // Approach 1: Reverse the Linked List (Iterative)
    // =========================================================

    /**
     * Reverses a singly linked list.
     *
     * @param head head of the linked list
     * @return new head after reversal
     */
    static Node reverseList(Node head) {
        Node prev = null;     // will become new head
        Node curr = head;     // used to traverse the list

        while (curr != null) {
            Node nextNode = curr.next; // store next node
            curr.next = prev;          // reverse current link
            prev = curr;               // move prev forward
            curr = nextNode;           // move curr forward
        }
        return prev;
    }

    /**
     * Adds one to the number represented by the linked list
     * using list reversal.
     *
     * @param head head of the linked list
     * @return head of updated linked list
     */
    static Node addOneUsingReverse(Node head) {

        // Step 1: Reverse the list to access least significant digit
        head = reverseList(head);

        Node curr = head;
        int carry = 1; // we start by adding 1

        // Step 2: Traverse list and handle carry
        while (curr != null && carry > 0) {

            int sum = curr.data + carry; // add carry to digit
            curr.data = sum % 10;        // update digit
            carry = sum / 10;            // compute new carry

            // If carry remains and we are at last node,
            // append a new node to hold the carry
            if (curr.next == null && carry > 0) {
                curr.next = new Node(carry);
                carry = 0;
            }

            curr = curr.next;
        }

        // Step 3: Reverse the list back to original order
        return reverseList(head);
    }

    // =========================================================
    // Approach 2: Recursion (No Reversal)
    // =========================================================

    /**
     * Recursive helper function that adds one starting
     * from the end of the linked list.
     *
     * @param node current node
     * @return carry generated after addition
     */
    static int addOneUtil(Node node) {

        // Base case: reached beyond last node
        // This is where we actually add 1
        if (node == null) {
            return 1;
        }

        // Recurse to the end of the list
        int carry = addOneUtil(node.next);

        // Add carry to current digit
        int sum = node.data + carry;
        node.data = sum % 10;

        // Return carry to previous node
        return sum / 10;
    }

    /**
     * Adds one to the number represented by the linked list
     * using recursion.
     *
     * @param head head of the linked list
     * @return head of updated linked list
     */
    static Node addOneUsingRecursion(Node head) {

        // Start recursion from head
        int carry = addOneUtil(head);

        // If carry remains after processing head,
        // create a new node and make it new head
        if (carry > 0) {
            Node newHead = new Node(carry);
            newHead.next = head;
            return newHead;
        }

        return head;
    }

}
