package linkedLists.mediumProblemsOfLL;

public class CheckIfLinkedListIsPalindrome {

    // Node class representing a node in the singly linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Checks if the singly linked list is a palindrome.
     * <p>
     * Steps:
     * 1. Find the middle using slow/fast pointers.
     * 2. Reverse the second half (in-place).
     * 3. Compare the first half and the reversed second half.
     * 4. Restore the second half (reverse again) to preserve the list.
     *
     * @param head head of the linked list
     * @return true if palindrome; false otherwise
     */
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true; // empty or single node is a palindrome
        }

        // Step 1: find middle (slow will point to middle for even/odd lengths)
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: reverse second half starting from slow.next
        Node secondHead = reverseList(slow.next);

        // Step 3: compare first half and reversed second half
        Node p1 = head;
        Node p2 = secondHead;
        boolean palindrome = true;
        while (p2 != null) {
            if (p1.data != p2.data) {
                palindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Step 4: restore the second half to its original order
        slow.next = reverseList(secondHead);

        return palindrome;
    }

    /**
     * Reverses a singly linked list iteratively and returns the new head.
     *
     * @param head head of the list to reverse
     * @return new head after reversal
     */
    private Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}