package binaryTrees.traversals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// Class to perform iterative postorder traversal using 2 stacks
public class IterativePostOrderTraversalTwoStacks {

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
     * Iterative postorder traversal using two stacks
     *
     * @param root Root of binary tree
     * @return List containing postorder traversal
     */
    public List<Integer> postOrder(Node root) {

        // Result list
        List<Integer> result = new ArrayList<>();

        // Edge case
        if (root == null) {
            return result;
        }

        // Stack 1 for traversal
        ArrayDeque<Node> stack1 = new ArrayDeque<>();

        // Stack 2 for storing reverse order
        ArrayDeque<Node> stack2 = new ArrayDeque<>();

        // Push root into stack1
        stack1.push(root);

        // Traverse tree
        while (!stack1.isEmpty()) {

            // Pop from stack1
            Node current = stack1.pop();

            // Push into stack2
            stack2.push(current);

            // Push left child into stack1
            if (current.left != null) {
                stack1.push(current.left);
            }

            // Push right child into stack1
            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        // Pop all elements from stack2 into result
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().data);
        }

        return result;
    }
}
