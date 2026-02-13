package linkedLists.hardProblemsOfLL;

public class FlatteningOfLinkedList {

    // Definition of special linked list node
    static class ListNode {
        int val;
        ListNode next;
        ListNode child;

        ListNode(int data) {
            val = data;
            next = null;
            child = null;
        }
    }

    // Merge two sorted linked lists using child pointer
    private ListNode merge(ListNode list1, ListNode list2) {

        // Dummy node to simplify merging
        ListNode dummyNode = new ListNode(-1);
        ListNode result = dummyNode;

        // Traverse both lists
        while (list1 != null && list2 != null) {

            // Compare values
            if (list1.val < list2.val) {

                result.child = list1;
                result = list1;
                list1 = list1.child;

            } else {

                result.child = list2;
                result = list2;
                list2 = list2.child;
            }

            // Remove next pointers
            result.next = null;
        }

        // Attach remaining nodes
        if (list1 != null)
            result.child = list1;
        else
            result.child = list2;

        // Ensure head.next is null
        if (dummyNode.child != null) {
            dummyNode.child.next = null;
        }

        // Return merged list head
        return dummyNode.child;
    }

    // Flatten the multi-level linked list
    public ListNode flattenLinkedList(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively flatten next list
        ListNode mergedHead = flattenLinkedList(head.next);

        // Merge current list with flattened list
        return merge(head, mergedHead);
    }
}
