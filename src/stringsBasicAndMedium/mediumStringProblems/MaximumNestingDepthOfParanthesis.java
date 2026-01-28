package stringsBasicAndMedium.mediumStringProblems;

public class MaximumNestingDepthOfParanthesis {
    public int maxDepth(String s) {

        // Stores the maximum nesting depth found so far
        int maxDepth = 0;

        // Tracks the current nesting depth while traversing the string
        int currentDepth = 0;

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {

            // If we encounter an opening parenthesis,
            // we are going one level deeper
            if (c == '(') {
                currentDepth++;

                // Update maxDepth if currentDepth exceeds it
                maxDepth = Math.max(maxDepth, currentDepth);
            }

            // If we encounter a closing parenthesis,
            // we move one level up (reduce depth)
            else if (c == ')') {
                currentDepth--;
            }

            // Ignore all other characters
        }

        // Return the maximum depth encountered
        return maxDepth;
    }
}
