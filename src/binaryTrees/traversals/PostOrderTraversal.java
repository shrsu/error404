package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.List;

// Class to perform postorder traversal of a binary tree
public class PostOrderTraversal {

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
     * Recursive helper function to perform postorder traversal
     *
     * @param root Current node being processed
     * @param arr  List to store traversal result
     */
    public void postorder(Node root, List<Integer> arr) {

        // Base case: if node is null, stop recursion
        if (root == null) {
            return;
        }

        // Step 1: Traverse left subtree
        postorder(root.left, arr);

        // Step 2: Traverse right subtree
        postorder(root.right, arr);

        // Step 3: Visit current node (Root)
        arr.add(root.data);
    }

    /**
     * Function to initiate postorder traversal
     *
     * @param root Root of the binary tree
     * @return List containing postorder traversal
     */
    public List<Integer> postOrder(Node root) {

        // Create list to store traversal result
        List<Integer> arr = new ArrayList<>();

        // Start postorder traversal
        postorder(root, arr);

        // Return traversal result
        return arr;
    }
}
