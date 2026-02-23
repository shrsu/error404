package stackAndQueues.learning;

import java.util.Stack;

// Class to implement Minimum Stack
public class ImplementMinStack {

    // Stack to store values (actual or encoded)
    private Stack<Integer> st;

    // Variable to store current minimum element
    private int mini;

    // Constructor → initialize stack
    public ImplementMinStack() {
        st = new Stack<>();
    }

    // Push operation → O(1)
    public void push(int value) {
        // Case 1: Stack is empty
        if (st.isEmpty()) {
            mini = value;      // First element is minimum
            st.push(value);    // Push normally
            return;
        }
        // Case 2: Value is greater than or equal to current minimum
        if (value >= mini) {
            st.push(value);    // Push normally
        } else {
            /*
             Value is smaller than current minimum.
             Encode the value so we can recover the previous minimum later.
             encodedValue = 2*value − mini
            */
            int encodedValue = 2 * value - mini;
            st.push(encodedValue);
            // Update minimum to new value
            mini = value;
        }
    }

    // Pop operation → O(1)
    public void pop() {
        if (st.isEmpty()) return;
        int top = st.pop();
        /*
         If popped value is less than minimum,
         it means it is an encoded value.
         Restore previous minimum using formula:
         previousMin = 2*currentMin − encodedValue
        */
        if (top < mini) {
            mini = 2 * mini - top;
        }
    }

    // Get top element → O(1)
    public int top() {
        if (st.isEmpty()) return -1;
        int top = st.peek();
        /*
         If top is encoded value,
         actual value is current minimum.
        */
        if (top < mini) {
            return mini;
        }
        return top;
    }

    // Get minimum element → O(1)
    public int getMin() {
        return mini;
    }
}
