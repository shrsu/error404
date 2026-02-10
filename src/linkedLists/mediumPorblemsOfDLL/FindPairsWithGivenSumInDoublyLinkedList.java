package linkedLists.mediumPorblemsOfDLL;

import java.util.ArrayList;
import java.util.List;

public class FindPairsWithGivenSumInDoublyLinkedList {

    // Doubly linked list node
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    /**
     * Find the tail (last node) of the list.
     *
     * @param head head of list
     * @return last node or null if list empty
     */
    private static Node findTail(Node head) {
        Node p = head;
        while (p != null && p.next != null) {
            p = p.next;
        }
        return p;
    }

    /**
     * Find all pairs of node values in a sorted doubly linked list that add up to sum.
     * Each pair corresponds to two distinct nodes.
     *
     * @param head head of the sorted doubly linked list
     * @param sum  target sum
     * @return list of int[2] pairs where pair[0] + pair[1] == sum
     */
    public static List<int[]> findPairsWithSum(Node head, int sum) {
        List<int[]> pairs = new ArrayList<>();
        if (head == null) return pairs;

        Node left = head;
        Node right = findTail(head);

        // Continue while left and right are distinct nodes and haven't crossed.
        // The condition left.data < right.data prevents using the same node or crossing.
        while (left != null && right != null && left != right && left.data < right.data) {
            int s = left.data + right.data;

            if (s == sum) {
                // Found a valid pair (values from two distinct nodes)
                pairs.add(new int[]{left.data, right.data});
                // Move both pointers inward to look for other pairs
                left = left.next;
                right = right.prev;
            } else if (s < sum) {
                // Need a larger sum — advance left
                left = left.next;
            } else {
                // Need a smaller sum — move right backward
                right = right.prev;
            }
        }
        return pairs;
    }

    // Utility to print pairs (for testing)
    public static void printPairs(List<int[]> pairs) {
        for (int[] p : pairs) {
            System.out.println("(" + p[0] + ", " + p[1] + ")");
        }
    }
}
