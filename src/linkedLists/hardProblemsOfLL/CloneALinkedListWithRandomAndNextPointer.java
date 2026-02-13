package linkedLists.hardProblemsOfLL;

import java.util.HashMap;
import java.util.Map;

public class CloneALinkedListWithRandomAndNextPointer {

    // Definition for a Node
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // Function to create a deep copy of the linked list
    public Node copyRandomListBruteForceApproach(Node head) {

        // If list is empty, return null
        if (head == null) {
            return null;
        }

        // Map to store original node -> copied node
        Map<Node, Node> originalToNewMap = new HashMap<>();

        // First pass: Create copy of each node and store in map
        Node current = head;

        // Create new head
        Node newHead = new Node(head.val);
        originalToNewMap.put(head, newHead);

        Node newCurrent = newHead;
        current = current.next;

        // Copy remaining nodes
        while (current != null) {

            // Create new node
            Node newNode = new Node(current.val);

            // Link new node using next pointer
            newCurrent.next = newNode;

            // Move pointer
            newCurrent = newCurrent.next;

            // Store mapping
            originalToNewMap.put(current, newNode);

            current = current.next;
        }

        // Second pass: Set random pointers
        current = head;
        newCurrent = newHead;

        while (current != null) {

            // If original random is null, set null
            if (current.random == null) {
                newCurrent.random = null;
            }
            // Otherwise, assign copied random
            else {
                newCurrent.random = originalToNewMap.get(current.random);
            }

            current = current.next;
            newCurrent = newCurrent.next;
        }

        // Return head of copied list
        return newHead;
    }
}
