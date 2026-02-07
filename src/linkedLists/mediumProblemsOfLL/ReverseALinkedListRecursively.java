package linkedLists.mediumProblemsOfLL;

public class ReverseALinkedListRecursively {

    // Definition for singly-linked list node
    class ListNode {
        int val;        // Value stored in the node
        ListNode next;  // Reference to the next node

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Recursive method to reverse the linked list
    public ListNode reverseList(ListNode head) {

        // Base case:
        // If list is empty or has only one node, it is already reversed
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        ListNode newHead = reverseList(head.next);

        // Store reference to the next node
        ListNode front = head.next;

        // Reverse the link
        front.next = head;

        // Break the original forward link to avoid cycle
        head.next = null;

        // Return the new head of the reversed list
        return newHead;
    }
}
