package stringsBasicAndMedium.mediumStringProblems;

public class ReverseEveryWordInString {
    /**
     * Reverses the order of words in the given string.
     * Extra spaces are removed, and words are separated
     * by a single space in the result.
     *
     * @param s input string
     * @return string with words in reversed order
     */
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1; // Start from the end

        while (i >= 0) {
            // Skip trailing or multiple spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            // No more words left
            if (i < 0) {
                break;
            }

            // Mark the end of the word
            int end = i;

            // Move left to find the start of the word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            // Extract the word
            String word = s.substring(i + 1, end + 1);

            // Append a space if this is not the first word
            if (result.length() > 0) {
                result.append(" ");
            }

            // Append the word
            result.append(word);
        }

        return result.toString();
    }
}
