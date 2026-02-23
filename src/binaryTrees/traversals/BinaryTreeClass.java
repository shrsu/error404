package binaryTrees.traversals;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeClass {

    // Node definition
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    private TreeNode root;

    // -------------------------
    // Basic helpers
    // -------------------------

    public TreeNode getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // -------------------------
    // Insert (level-order)
    // -------------------------
    public void insert(int data) {
        TreeNode newNode = new TreeNode(data);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            if (cur.left == null) {
                cur.left = newNode;
                return;
            } else {
                q.add(cur.left);
            }

            if (cur.right == null) {
                cur.right = newNode;
                return;
            } else {
                q.add(cur.right);
            }
        }
    }

    // -------------------------
    // Search (DFS)
    // -------------------------
    public boolean contains(int key) {
        return contains(root, key);
    }

    private boolean contains(TreeNode node, int key) {
        if (node == null) return false;
        if (node.data == key) return true;
        return contains(node.left, key) || contains(node.right, key);
    }

    // -------------------------
    // Traversals (recursive)
    // -------------------------
    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(TreeNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // -------------------------
    // Level Order (BFS)
    // -------------------------
    public void levelOrder() {
        if (root == null) {
            System.out.println();
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            System.out.print(cur.data + " ");

            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }

        System.out.println();
    }

    // -------------------------
    // Height
    // -------------------------
    public int height() {
        return height(root);
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // -------------------------
    // Count nodes
    // -------------------------
    public int size() {
        return size(root);
    }

    private int size(TreeNode node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    // -------------------------
    // Count leaf nodes
    // -------------------------
    public int leafCount() {
        return leafCount(root);
    }

    private int leafCount(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return leafCount(node.left) + leafCount(node.right);
    }

    // -------------------------
    // Clear tree
    // -------------------------
    public void clear() {
        root = null;
    }
}
