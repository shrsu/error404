package linkedLists.mediumProblemsOfLL;

public class ReverseALinkedListIteratively {

    // Definition for singly-linked list node
    static class ListNode {
        int val;        // Value stored in the node
        ListNode next;  // Reference to the next node

        // Constructor to initialize node value
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to reverse a linked list iteratively
    public ListNode reverseList(ListNode head) {

        // Pointer to track the previous node
        ListNode prev = null;

        // Pointer to traverse the list
        ListNode curr = head;

        // Traverse the linked list
        while (curr != null) {

            // Save the next node
            ListNode next = curr.next;

            // Reverse the current node's pointer
            curr.next = prev;

            // Move prev one step forward
            prev = curr;

            // Move curr one step forward
            curr = next;
        }

        // prev now points to the new head of the reversed list
        return prev;
    }
}
