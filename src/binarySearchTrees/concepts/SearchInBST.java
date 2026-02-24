package binarySearchTrees.concepts;

public class SearchInBST {

    // Definition of TreeNode
    static class TreeNode {
        int val;          // Value stored in the node
        TreeNode left;   // Reference to left child
        TreeNode right;  // Reference to right child

        // Constructor to initialize node
        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    /**
     * Searches for a target value in the BST.
     *
     * @param root   Root node of the BST
     * @param target Value to search
     * @return Node containing target value, or null if not found
     */
    public TreeNode searchBST(TreeNode root, int target) {

        // Traverse until node becomes null or target is found
        while (root != null) {

            // Case 1: Target found
            if (root.val == target) {
                return root;
            }

            // Case 2: Target is smaller → move to left subtree
            else if (target < root.val) {
                root = root.left;
            }

            // Case 3: Target is greater → move to right subtree
            else {
                root = root.right;
            }
        }

        // Target not found
        return null;
    }

    public TreeNode searchBSTRecursive(TreeNode root, int target) {

        // Base case: node is null or target found
        if (root == null || root.val == target) {
            return root;
        }

        // Search in left subtree
        if (target < root.val) {
            return searchBSTRecursive(root.left, target);
        }

        // Search in right subtree
        return searchBSTRecursive(root.right, target);
    }

}
