package linkedLists.mediumProblemsOfLL;

public class AddTwoNumbersInLinkedList {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode();

        // Pointer to build the result list
        ListNode current = dummy;

        int carry = 0;

        // Traverse both lists until all digits and carry are processed
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            // Add value from l1 if available
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add value from l2 if available
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Update carry for next iteration
            carry = sum / 10;

            // Create a new node with the current digit
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        // Return the head of the resulting list
        return dummy.next;
    }
}
