package linkedLists.mediumProblemsOfLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortLinkedList {

    /**
     * Definition for singly-linked list.
     */
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

    /* =========================================================
       Approach 1: Array + Sort
       Time: O(n log n)
       Space: O(n)
       ========================================================= */
    public ListNode sortListUsingArray(ListNode head) {
        if (head == null) return null;

        List<Integer> values = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        Collections.sort(values);

        curr = head;
        for (int v : values) {
            curr.val = v;
            curr = curr.next;
        }

        return head;
    }

    /* =========================================================
       Approach 2: Merge Sort on Linked List
       Time: O(n log n)
       Space: O(log n) (recursion stack)
       ========================================================= */
    public ListNode sortListUsingMergeSort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = findMiddle(head);
        ListNode right = mid.next;
        mid.next = null;

        ListNode leftSorted = sortListUsingMergeSort(head);
        ListNode rightSorted = sortListUsingMergeSort(right);

        return merge(leftSorted, rightSorted);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
