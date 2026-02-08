package linkedLists.mediumProblemsOfLL;

import java.util.Stack;

public class CheckIfLinkedListIsPalindrome {

    // Node definition
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

    /* =====================================================
       Method 1: Brute Force using Stack
       Time:  O(N)
       Space: O(N)
       ===================================================== */

    public boolean isPalindromeBruteForce(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node temp = head;

        // Push all values to stack
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        // Compare while popping
        temp = head;
        while (temp != null) {
            if (temp.data != stack.pop()) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }

    /* =====================================================
       Method 2: Optimal In-place Approach
       Time:  O(N)
       Space: O(1)
       ===================================================== */

    public boolean isPalindromeOptimal(Node head) {
        // Empty or single-node list is always a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the list
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        Node secondHalfHead = reverseList(slow.next);

        // Step 3: Compare both halves
        Node first = head;
        Node second = secondHalfHead;
        boolean isPalindrome = true;

        while (second != null) {
            if (first.data != second.data) {
                isPalindrome = false;
                break;
            }
            first = first.next;
            second = second.next;
        }

        // Step 4: Restore the list
        slow.next = reverseList(secondHalfHead);

        return isPalindrome;
    }

    /* =====================================================
       Helper Method: Reverse a Linked List
       ===================================================== */

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
