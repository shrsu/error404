package stackAndQueues.prefixInfixPostFixConversionProblems;

import java.util.ArrayDeque;

public class InfixToPostfix {

    // Function to return precedence of operators
    public static int prec(char c) {
        if (c == '^')  // Exponent operator has highest precedence
            return 3;
        else if (c == '/' || c == '*')  // Multiplication and division have higher precedence than addition
            return 2;
        else if (c == '+' || c == '-')  // Addition and subtraction have lowest precedence
            return 1;
        else
            return -1;
    }

    // Function to convert infix expression to postfix expression
    public static void infixToPostfix(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();  // Stack to hold operators and parentheses
        StringBuilder result = new StringBuilder();  // StringBuilder to hold the resulting postfix expression

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the scanned character is an operand, add it to the result string
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }

            // If the scanned character is an ‘(‘, push it to the stack
            else if (c == '(') {
                st.push('(');
            }

            // If the scanned character is a ‘)’, pop from stack until an ‘(‘ is encountered
            else if (c == ')') {
                while (st.peek() != '(') {
                    result.append(st.pop());
                }
                st.pop();  // Pop the ‘(‘ from the stack
            }

            // If an operator is scanned
            else {
                while (!st.isEmpty() && prec(c) <= prec(st.peek())) {
                    result.append(st.pop());
                }
                st.push(c);  // Push the current operator to the stack
            }
        }

        // Pop all the remaining elements from the stack
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        System.out.println("Postfix expression: " + result.toString());  // Output the result
    }
}
