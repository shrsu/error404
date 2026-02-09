package linkedLists.mediumProblemsOfLL;

public class FindIntersectionPointOfYLinkedList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /* =========================================================
       Approach 1: Difference of Lengths
       ========================================================= */

    // Returns the length difference between two linked lists
    private int getLengthDifference(Node headA, Node headB) {
        int lenA = 0, lenB = 0;

        while (headA != null) {
            lenA++;
            headA = headA.next;
        }

        while (headB != null) {
            lenB++;
            headB = headB.next;
        }

        return lenA - lenB;
    }

    // Finds intersection using length difference method
    public Node getIntersectionByLength(Node headA, Node headB) {
        int diff = getLengthDifference(headA, headB);

        // Advance the longer list by the length difference
        if (diff > 0) {
            while (diff-- > 0) headA = headA.next;
        } else {
            while (diff++ < 0) headB = headB.next;
        }

        // Traverse both lists together
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA; // Intersection found
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null; // No intersection
    }

    /* =========================================================
       Approach 2: Two-Pointer Switching Technique
       ========================================================= */

    // Finds intersection using pointer switching method
    public Node getIntersectionBySwitching(Node headA, Node headB) {
        Node p1 = headA;
        Node p2 = headB;

        // Both pointers traverse A + B
        while (p1 != p2) {
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }

        return p1; // Intersection node or null
    }
}
