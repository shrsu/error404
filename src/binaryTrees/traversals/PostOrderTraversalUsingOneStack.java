package binaryTrees.traversals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// Class to perform iterative postorder traversal using one stack
public class PostOrderTraversalUsingOneStack {

    // Definition of Binary Tree Node
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    /**
     * Iterative postorder traversal using one stack
     *
     * @param root Root of binary tree
     * @return List containing postorder traversal
     */
    public List<Integer> postOrder(Node root) {

        List<Integer> result = new ArrayList<>();

        ArrayDeque<Node> stack = new ArrayDeque<>();

        Node current = root;
        Node lastVisited = null;

        while (current != null || !stack.isEmpty()) {

            // Move left and push nodes
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            Node peekNode = stack.peek();

            // If right child exists and not yet visited
            if (peekNode.right != null && lastVisited != peekNode.right) {

                current = peekNode.right;

            } else {

                // Visit node
                result.add(peekNode.data);

                lastVisited = stack.pop();
            }
        }

        return result;
    }
}