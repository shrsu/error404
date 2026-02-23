package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.List;

// Class to perform preorder traversal of a binary tree
public class PreOrderTraversal {

    // Definition of a Binary Tree Node
    static class Node {
        int data;     // Value stored in node
        Node left;    // Reference to left child
        Node right;   // Reference to right child

        // Constructor to initialize node with value
        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    /**
     * Recursive helper function to perform preorder traversal
     *
     * @param root Current node being processed
     * @param arr  List to store traversal result
     */
    public void preorder(Node root, java.util.List<Integer> arr) {

        // Base case: if node is null, nothing to traverse
        if (root == null) {
            return;
        }

        // Step 1: Visit the current node (Root)
        arr.add(root.data);

        // Step 2: Traverse left subtree
        preorder(root.left, arr);

        // Step 3: Traverse right subtree
        preorder(root.right, arr);
    }

    /**
     * Function to initiate preorder traversal
     *
     * @param root Root of the binary tree
     * @return List containing preorder traversal
     */
    public List<Integer> preOrder(Node root) {

        // Create list to store traversal result
        List<Integer> arr = new ArrayList<>();

        // Start preorder traversal from root
        preorder(root, arr);

        // Return final traversal list
        return arr;
    }
}
