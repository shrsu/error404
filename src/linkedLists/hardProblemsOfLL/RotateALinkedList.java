package linkedLists.hardProblemsOfLL;

public class RotateALinkedList {
    /**
     * Definition for singly-linked list.
     */
    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Helper method to find length of the linked list
    private int getLen(ListNode head) {
        int len = 0;

        // Traverse and count nodes
        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    public ListNode rotateRight(ListNode head, int k) {

        // Edge cases:
        // 1. Empty list
        // 2. Only one node
        // 3. No rotation needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length
        int len = getLen(head);

        // Step 2: Reduce unnecessary rotations
        k = k % len;

        if (k == 0) {
            return head;
        }

        // Step 3: Find tail node
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        // Make list circular
        tail.next = head;

        // Step 4: Find new tail position
        int steps = len - k - 1;

        ListNode newTail = head;

        // Move to new tail
        for (int i = 0; i < steps; i++) {
            newTail = newTail.next;
        }

        // Step 5: Set new head
        ListNode newHead = newTail.next;

        // Break circular link
        newTail.next = null;

        return newHead;
    }
}
