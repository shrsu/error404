package linkedLists.mediumProblemsOfLL;

public class SegregateOddAndEvenNodesInLinkedList {

    static class ListNode {
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

    /**
     * Reorders the linked list so that all nodes at odd indices
     * come first, followed by nodes at even indices.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode oddEvenList(ListNode head) {

        // Edge case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers
        ListNode odd = head;           // pointer for odd-indexed nodes
        ListNode even = head.next;     // pointer for even-indexed nodes
        ListNode evenHead = even;      // store head of even list

        // Rewire next pointers to separate odd and even nodes
        while (even != null && even.next != null) {
            odd.next = even.next;      // link odd to next odd
            odd = odd.next;

            even.next = odd.next;      // link even to next even
            even = even.next;
        }

        // Attach even list after odd list
        odd.next = evenHead;

        return head;
    }
}
