package binaryTrees.traversals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// Class to perform iterative inorder traversal
public class IterativeInOrderTraversal {

    // Definition of Binary Tree Node
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor
        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    /**
     * Iterative inorder traversal using ArrayDeque
     *
     * @param root Root of binary tree
     * @return List containing inorder traversal
     */
    public List<Integer> inOrder(Node root) {

        // Result list
        List<Integer> result = new ArrayList<>();

        // Stack using ArrayDeque
        ArrayDeque<Node> stack = new ArrayDeque<>();

        // Start from root
        Node current = root;

        // Traverse until done
        while (current != null || !stack.isEmpty()) {

            // Step 1: Reach leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Step 2: Process node
            current = stack.pop();
            result.add(current.data);

            // Step 3: Move to right subtree
            current = current.right;
        }

        return result;
    }
}
