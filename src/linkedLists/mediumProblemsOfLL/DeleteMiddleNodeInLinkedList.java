package linkedLists.mediumProblemsOfLL;

public class DeleteMiddleNodeInLinkedList {

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteMiddle(ListNode head) {

        // Edge case: if list is empty or has only one node
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head.next.next;

        // Move fast by 2 steps and slow by 1 step
        // slow will stop at the node BEFORE the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
        slow.next = slow.next.next;

        // Return modified list
        return head;
    }
}
