package recursionPatterns.getAStrongHold;

import java.util.Stack;

public class SortAStackUsingRecursion {

    /*
     * ============================================================
     * Helper function to insert an element into sorted stack
     * Maintains descending order (largest element on top)
     * ============================================================
     */
    public void insert(Stack<Integer> stack, int temp) {

        // Base condition:
        // If stack is empty OR top element is smaller than or equal to temp
        if (stack.isEmpty() || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }

        // Otherwise, remove top element
        int top = stack.pop();

        // Recursively insert temp in correct position
        insert(stack, temp);

        // Push removed element back
        stack.push(top);
    }


    /*
     * ============================================================
     * Main function to sort stack using recursion
     * ============================================================
     */
    public void sortStack(Stack<Integer> stack) {

        // Base condition: stop when stack becomes empty
        if (stack.isEmpty()) {
            return;
        }

        // Remove top element
        int temp = stack.pop();

        // Recursively sort remaining stack
        sortStack(stack);

        // Insert element back in sorted position
        insert(stack, temp);
    }
}
