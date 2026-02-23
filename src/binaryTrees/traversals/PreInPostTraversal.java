package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreInPostTraversal {

    // Binary Tree Node class
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor
        Node(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    // Custom Pair class (since Java doesn't have built-in mutable Pair)
    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    /**
     * Function to get preorder, inorder, and postorder
     * in a single traversal
     */
    public List<List<Integer>> preInPostTraversal(Node root) {

        // Lists to store results
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        // Edge case: empty tree
        if (root == null) {
            return new ArrayList<>();
        }

        // Stack stores Pair(Node, state)
        Stack<Pair> stack = new Stack<>();

        // Start with root in preorder state
        stack.push(new Pair(root, 1));

        // Traverse until stack is empty
        while (!stack.isEmpty()) {

            Pair current = stack.pop();

            // STATE 1 → PREORDER
            if (current.state == 1) {

                // Add to preorder
                preorder.add(current.node.data);

                // Move to inorder state
                current.state = 2;

                // Push same node back with updated state
                stack.push(current);

                // Push left child if exists
                if (current.node.left != null) {
                    stack.push(new Pair(current.node.left, 1));
                }
            }

            // STATE 2 → INORDER
            else if (current.state == 2) {

                // Add to inorder
                inorder.add(current.node.data);

                // Move to postorder state
                current.state = 3;

                // Push same node back with updated state
                stack.push(current);

                // Push right child if exists
                if (current.node.right != null) {
                    stack.push(new Pair(current.node.right, 1));
                }
            }

            // STATE 3 → POSTORDER
            else {

                // Add to postorder
                postorder.add(current.node.data);
            }
        }

        // Combine results
        List<List<Integer>> result = new ArrayList<>();
        result.add(preorder);
        result.add(inorder);
        result.add(postorder);

        return result;
    }

    // Helper function to print traversal
    public static void printList(String name, List<Integer> list) {
        System.out.print(name + ": ");
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}