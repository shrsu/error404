package linkedLists.hardProblemsOfLL;

public class ReverseLinkedListInGroupOfSizeK {

    static class ListNode {
        int data;
        ListNode prev;
        ListNode next;

        // Constructor
        ListNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode temp = head;
        ListNode prevGroupTail = null;

        while (temp != null) {

            // Step 1: Find kth node
            ListNode kth = getKthNode(temp, k);
            if (kth == null) {
                if (prevGroupTail != null) {
                    prevGroupTail.next = temp;
                }
                break;
            }

            // Step 2: Store next group start
            ListNode nextGroup = kth.next;
            kth.next = null;

            // Step 3: Reverse current group
            ListNode newHead = reverse(temp);

            // Step 4: Connect groups
            if (temp == head) {
                head = newHead;
            } else {
                prevGroupTail.next = newHead;
            }

            // Update previous group tail
            prevGroupTail = temp;

            // Move temp to next group
            temp = nextGroup;
        }

        return head;
    }

    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k > 1) {
            node = node.next;
            k--;
        }
        return node;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
