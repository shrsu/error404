package stringsBasicAndMedium.mediumStringProblems;

public class LongestPalindromicSubstringWithoutDP {

    public String longestPalindrome(String str) {
        int start = 0;
        int end = 0;

        // Iterate through each character as a potential center
        for (int center = 0; center < str.length(); center++) {

            // Case 1: Odd-length palindrome (single character center)
            int lenOdd = expandFromCenter(str, center, center);

            // Case 2: Even-length palindrome (between two characters)
            int lenEven = expandFromCenter(str, center, center + 1);

            // Choose the longer palindrome from the two cases
            int maxLen = Math.max(lenOdd, lenEven);

            // Update boundaries if a longer palindrome is found
            if (maxLen > end - start) {
                start = center - (maxLen - 1) / 2;
                end = center + maxLen / 2;
            }
        }

        // Extract and return the longest palindromic substring
        return str.substring(start, end + 1);
    }

    /**
     * Expands outward from the given left and right indices
     * while the characters match.
     *
     * @return the length of the palindrome found
     */
    private int expandFromCenter(String str, int left, int right) {
        while (left >= 0 &&
                right < str.length() &&
                str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        // Length of palindrome after expansion stops
        return right - left - 1;
    }
}
