package stringsBasicAndMedium.basicAndEasyProblems;

public class LargestOddNumberInString {

    /**
     * Returns the largest-valued odd integer (as a string) that is a non-empty
     * substring of the input numeric string. If no odd digit exists, returns "".
     *
     * The largest odd substring is the longest prefix that ends at the last
     * odd digit in the original string.
     *
     * @param num the input numeric string (no leading zeros guaranteed by constraints)
     * @return the largest odd integer substring, or "" if none exists
     */
    public String largestOddNumber(String num) {
        // Find index of the last odd digit
        int lastOdd = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            if ((digit & 1) == 1) { // digit % 2 == 1
                lastOdd = i;
                break;
            }
        }

        // If no odd digit, return empty string
        if (lastOdd == -1) {
            return "";
        }

        // Return the longest substring from start up to and including lastOdd
        return num.substring(0, lastOdd + 1);
    }
}
