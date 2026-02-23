package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.List;

// Class to perform inorder traversal of a binary tree
public class InOrderTraversal {

    // Definition of Binary Tree Node
    static class Node {
        int data;     // Value stored in node
        Node left;    // Reference to left child
        Node right;   // Reference to right child

        // Constructor to initialize node
        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    /**
     * Recursive helper function to perform inorder traversal
     *
     * @param root Current node being processed
     * @param arr  List to store traversal result
     */
    public void inorder(Node root, List<Integer> arr) {

        // Base case: if node is null, stop recursion
        if (root == null) {
            return;
        }

        // Step 1: Traverse left subtree
        inorder(root.left, arr);

        // Step 2: Visit current node (Root)
        arr.add(root.data);

        // Step 3: Traverse right subtree
        inorder(root.right, arr);
    }

    /**
     * Function to initiate inorder traversal
     *
     * @param root Root of the binary tree
     * @return List containing inorder traversal
     */
    public List<Integer> inOrder(Node root) {

        // Create list to store traversal result
        List<Integer> arr = new ArrayList<>();

        // Start inorder traversal
        inorder(root, arr);

        // Return traversal result
        return arr;
    }
}
