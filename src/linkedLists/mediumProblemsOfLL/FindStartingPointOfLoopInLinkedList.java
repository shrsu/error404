package linkedLists.mediumProblemsOfLL;

public class FindStartingPointOfLoopInLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Detects the starting point of a cycle in a linked list using
     * Floyd's Tortoise and Hare algorithm.
     *
     * @param head Head of the linked list
     * @return Starting node of the cycle, or null if no cycle exists
     */
    public ListNode detectCycle(ListNode head) {
        // Edge case: empty list or single node
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;          // move slow by 1
            fast = fast.next.next;    // move fast by 2

            // Cycle detected
            if (slow == fast) {
                // Step 2: Find cycle entry point
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Both pointers now point to the start of the cycle
                return slow;
            }
        }

        // No cycle found
        return null;
    }
}
