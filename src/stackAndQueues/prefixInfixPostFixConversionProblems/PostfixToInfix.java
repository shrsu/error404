package stackAndQueues.prefixInfixPostFixConversionProblems;

import java.util.ArrayDeque;

public class PostfixToInfix {
    // Function to convert postfix to infix
    public String postfixToInfix(String postfix) {
        ArrayDeque<String> s = new ArrayDeque<>();
        int n = postfix.length();

        // Traverse the postfix expression from left to right
        for (int i = 0; i < n; i++) {
            char c = postfix.charAt(i);

            // If the character is an operand, push it to the stack
            if (Character.isLetterOrDigit(c)) {
                s.push(String.valueOf(c));
            } else {
                // Pop two operands from the stack
                String op2 = s.pop();
                String op1 = s.pop();

                // Form the new infix expression and push back to stack
                s.push("(" + op1 + c + op2 + ")");
            }
        }

        // The final element in the stack is the result
        return s.peek();
    }
}
