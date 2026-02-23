package stackAndQueues.learning;

import java.util.Stack;

public class BalancedParenthesis {

    /**
     * Checks whether the given string contains valid parentheses.
     * <p>
     * Rules:
     * 1. Every opening bracket must have a matching closing bracket.
     * 2. Brackets must close in the correct order.
     * 3. No closing bracket should appear without a corresponding opening bracket.
     *
     * @param s Input string containing only (), {}, []
     * @return true if valid, false otherwise
     */
    public boolean isValid(String s) {

        // Stack to store opening brackets
        Stack<Character> stack = new Stack<>();

        // Traverse each character in the string
        for (char ch : s.toCharArray()) {

            // Case 1: Opening brackets → push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // Case 2: Closing brackets
            else {

                // If stack is empty → no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                // Pop the most recent opening bracket
                char top = stack.pop();

                // Check if brackets match
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {

                    return false;
                }
            }
        }

        // If stack is empty → all brackets matched
        return stack.isEmpty();
    }
}
