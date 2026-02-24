package binarySearchTrees.concepts;

// Binary Search Tree Implementation in Java
public class BinarySearchTree {

    // Node class represents each node in BST
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Root of BST
    private Node root;

    // ================================
    // INSERT OPERATION
    // ================================

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {

        // If tree is empty, create new node
        if (root == null) {
            return new Node(value);
        }

        // Insert in left subtree
        if (value < root.data) {
            root.left = insertRec(root.left, value);
        }

        // Insert in right subtree
        else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }

        // Ignore duplicates
        return root;
    }

    // ================================
    // SEARCH OPERATION
    // ================================

    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {

        // Base case
        if (root == null)
            return false;

        // Found
        if (root.data == value)
            return true;

        // Search left
        if (value < root.data)
            return searchRec(root.left, value);

            // Search right
        else
            return searchRec(root.right, value);
    }

    // ================================
    // INORDER TRAVERSAL (Sorted Order)
    // ================================

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {

        if (root != null) {

            inorderRec(root.left);

            System.out.print(root.data + " ");

            inorderRec(root.right);
        }
    }

    // ================================
    // PREORDER TRAVERSAL
    // ================================

    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) {

        if (root != null) {

            System.out.print(root.data + " ");

            preorderRec(root.left);

            preorderRec(root.right);
        }
    }

    // ================================
    // POSTORDER TRAVERSAL
    // ================================

    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node root) {

        if (root != null) {

            postorderRec(root.left);

            postorderRec(root.right);

            System.out.print(root.data + " ");
        }
    }

    // ================================
    // FIND MINIMUM
    // ================================

    public int findMin() {

        Node current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    // ================================
    // FIND MAXIMUM
    // ================================

    public int findMax() {

        Node current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    // ================================
    // DELETE OPERATION
    // ================================

    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node root, int value) {

        if (root == null)
            return null;

        // Go left
        if (value < root.data) {
            root.left = deleteRec(root.left, value);
        }

        // Go right
        else if (value > root.data) {
            root.right = deleteRec(root.right, value);
        }

        // Node found
        else {

            // Case 1: No child
            if (root.left == null && root.right == null)
                return null;

                // Case 2: One child
            else if (root.left == null)
                return root.right;

            else if (root.right == null)
                return root.left;

                // Case 3: Two children
            else {

                // Find inorder successor
                Node successor = findMinNode(root.right);

                root.data = successor.data;

                root.right = deleteRec(root.right, successor.data);
            }
        }

        return root;
    }

    private Node findMinNode(Node root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

}
