package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.List;

// Class to perform postorder traversal
public class PostOrderTraversalUsingOneStack {

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
     * Recursive helper function for postorder traversal
     *
     * @param root Current node
     * @param result List to store traversal
     */
    public void postorder(Node root, List<Integer> result) {

        // Base case: if node is null, stop recursion
        if (root == null) {
            return;
        }

        // Step 1: Traverse left subtree
        postorder(root.left, result);

        // Step 2: Traverse right subtree
        postorder(root.right, result);

        // Step 3: Visit current node
        result.add(root.data);
    }

    /**
     * Function to start postorder traversal
     *
     * @param root Root of binary tree
     * @return List containing postorder traversal
     */
    public List<Integer> postOrder(Node root) {

        // List to store result
        List<Integer> result = new ArrayList<>();

        // Start traversal
        postorder(root, result);

        return result;
    }
}