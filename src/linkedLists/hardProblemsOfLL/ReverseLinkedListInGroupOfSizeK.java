package linkedLists.hardProblemsOfLL;

public class ReverseLinkedListInGroupOfSizeK {

    // Doubly Linked List Node
    static class ListNode {
        int data;
        ListNode prev;  // Not used in current logic (we are treating it like singly list)
        ListNode next;

        // Constructor
        ListNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    /*
     * Reverses the linked list in groups of size k.
     * If remaining nodes are fewer than k, they remain unchanged.
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        // Edge case: empty list or k = 1 (no reversal needed)
        if (head == null || k == 1) return head;

        ListNode temp = head;              // Pointer to traverse list
        ListNode prevGroupTail = null;     // Stores tail of previous reversed group

        // Traverse the entire list
        while (temp != null) {

            // Step 1: Find the kth node from current position
            ListNode kth = getKthNode(temp, k);

            // If fewer than k nodes remain, do not reverse
            if (kth == null) {

                // Connect last reversed group to remaining nodes
                if (prevGroupTail != null) {
                    prevGroupTail.next = temp;
                }
                break;
            }

            // Step 2: Store the next group's starting node
            ListNode nextGroup = kth.next;

            // Break the link to isolate current group
            kth.next = null;

            // Step 3: Reverse current group
            ListNode newHead = reverse(temp);

            // Step 4: Connect previous group to newly reversed group
            if (temp == head) {
                // If first group, update overall head
                head = newHead;
            } else {
                // Connect previous group's tail to new head
                prevGroupTail.next = newHead;
            }

            // After reversal, 'temp' becomes the tail of this group
            prevGroupTail = temp;

            // Move temp to the next group
            temp = nextGroup;
        }

        return head;
    }

    /*
     * Returns the kth node from the current node.
     * If fewer than k nodes exist, returns null.
     */
    private ListNode getKthNode(ListNode node, int k) {

        // Move k-1 steps forward
        while (node != null && k > 1) {
            node = node.next;
            k--;
        }

        return node;  // May return null if insufficient nodes
    }

    /*
     * Reverses a singly linked list and returns new head.
     */
    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        // Standard linked list reversal
        while (curr != null) {
            ListNode next = curr.next;  // Store next node
            curr.next = prev;           // Reverse current link
            prev = curr;                // Move prev forward
            curr = next;                // Move curr forward
        }

        // prev becomes the new head after reversal
        return prev;
    }
}

