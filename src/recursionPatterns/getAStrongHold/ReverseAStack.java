package recursionPatterns.getAStrongHold;

import java.util.Stack;

public class ReverseAStack {

    /*
     * ============================================================
     * Function to insert an element at the bottom of the stack
     * ============================================================
     */
    public static void insertAtBottom(Stack<Integer> st, int val) {

        // Base case:
        // If stack is empty, push the value
        if (st.isEmpty()) {
            st.push(val);
            return;
        }

        // Remove top element
        int topVal = st.pop();

        // Recursively insert value at bottom
        insertAtBottom(st, val);

        // Push removed element back
        st.push(topVal);
    }


    /*
     * ============================================================
     * Function to reverse the stack using recursion
     * ============================================================
     */
    public static void reverseStack(Stack<Integer> st) {

        // Base case: empty stack
        if (st.isEmpty()) {
            return;
        }

        // Remove top element
        int topVal = st.pop();

        // Reverse remaining stack
        reverseStack(st);

        // Insert removed element at bottom
        insertAtBottom(st, topVal);
    }

}
