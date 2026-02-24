package binarySearchTrees.concepts;

public class BSTMinMax {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Find minimum value node
    public TreeNode findMin(TreeNode root) {

        if (root == null)
            return null;

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // Find maximum value node
    public TreeNode findMax(TreeNode root) {

        if (root == null)
            return null;

        while (root.right != null) {
            root = root.right;
        }

        return root;
    }

    /**
     * Finds minimum value node in BST
     *
     * @param root Root of BST
     * @return Node containing minimum value
     */
    public TreeNode findMinIteratively(TreeNode root) {

        // Edge case: empty tree
        if (root == null) {
            return null;
        }

        // Move left until leftmost node is reached
        while (root.left != null) {
            root = root.left;
        }

        // Leftmost node contains minimum value
        return root;
    }

    /**
     * Finds maximum value node in BST
     *
     * @param root Root of BST
     * @return Node containing maximum value
     */
    public TreeNode findMaxIteratively(TreeNode root) {

        // Edge case: empty tree
        if (root == null) {
            return null;
        }

        // Move right until rightmost node is reached
        while (root.right != null) {
            root = root.right;
        }

        // Rightmost node contains maximum value
        return root;
    }
}
