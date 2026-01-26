package stringsBasicAndMedium.basicAndEasyProblems;

public class RemoveOutermostParentheses {

    /**
     * Removes the outermost parentheses from every primitive
     * valid parentheses substring in the given string.
     *
     * @param s a valid parentheses string
     * @return the processed string after removing outermost parentheses
     */
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int level = 0; // Tracks current nesting depth

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // Only append '(' if it is not the outermost one
                if (level > 0) {
                    result.append(ch);
                }
                level++; // Enter a deeper nesting level
            } else { // ch == ')'
                level--; // Exit the current nesting level
                // Only append ')' if it is not the outermost one
                if (level > 0) {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}
