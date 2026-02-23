package binaryTrees.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Class to perform Level Order Traversal (BFS)
public class LevelOrderTraversal {

    // Definition of Binary Tree Node
    static class Node {
        int data;     // Value of node
        Node left;    // Left child
        Node right;   // Right child

        // Constructor
        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    /**
     * Function to perform level order traversal
     *
     * @param root Root of binary tree
     * @return List of levels, each level contains node values
     */
    public List<List<Integer>> levelOrder(Node root) {

        // Final result list
        List<List<Integer>> result = new ArrayList<>();

        // Edge case: empty tree
        if (root == null) {
            return result;
        }

        // Queue for BFS traversal
        Queue<Node> queue = new LinkedList<>();

        // Add root node
        queue.offer(root);

        // Process until queue is empty
        while (!queue.isEmpty()) {

            // Get number of nodes in current level
            int levelSize = queue.size();

            // List to store current level values
            List<Integer> level = new ArrayList<>();

            // Process all nodes of current level
            for (int i = 0; i < levelSize; i++) {

                // Remove node from queue
                Node current = queue.poll();

                // Add node value to level list
                level.add(current.data);

                // Add left child if exists
                if (current.left != null) {
                    queue.offer(current.left);
                }

                // Add right child if exists
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            // Add current level to result
            result.add(level);
        }

        // Return final level order traversal
        return result;
    }
}
