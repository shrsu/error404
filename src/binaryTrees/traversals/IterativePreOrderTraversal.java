package binaryTrees.traversals;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// Class to perform iterative preorder traversal using ArrayDeque
public class IterativePreOrderTraversal {

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
     * Iterative preorder traversal using ArrayDeque (recommended)
     *
     * @param root Root of the binary tree
     * @return List containing preorder traversal
     */
    public List<Integer> preOrder(Node root) {

        // List to store result
        List<Integer> result = new ArrayList<>();

        // Edge case: empty tree
        if (root == null) {
            return result;
        }

        // Use ArrayDeque as stack
        ArrayDeque<Node> stack = new ArrayDeque<>();

        // Push root
        stack.push(root);

        // Process until empty
        while (!stack.isEmpty()) {

            // Pop top node
            Node current = stack.pop();

            // Visit node
            result.add(current.data);

            // Push right child first
            if (current.right != null) {
                stack.push(current.right);
            }

            // Push left child
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return result;
    }
}
