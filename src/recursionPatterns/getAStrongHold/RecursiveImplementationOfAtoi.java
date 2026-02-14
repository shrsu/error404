package recursionPatterns.getAStrongHold;

public class RecursiveImplementationOfAtoi {

    // Define integer bounds
    static final int INT_MIN_VAL = -2147483648;
    static final int INT_MAX_VAL = 2147483647;

    /**
     * Recursive helper function to build the integer.
     *
     * @param s    Input string
     * @param i    Current index in string
     * @param num  Current number built so far (use long to detect overflow)
     * @param sign Sign of number (+1 or -1)
     * @return     Final integer result clamped within INT range
     */
    static int helper(String s, int i, long num, int sign) {

        // Base case:
        // Stop if end of string OR current character is not a digit
        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return (int)(sign * num);
        }

        // Convert current character to digit
        int digit = s.charAt(i) - '0';

        // Update number
        num = num * 10 + digit;

        // Check overflow / underflow and clamp immediately
        if (sign * num <= INT_MIN_VAL) {
            return INT_MIN_VAL;
        }

        if (sign * num >= INT_MAX_VAL) {
            return INT_MAX_VAL;
        }

        // Recursive call for next character
        return helper(s, i + 1, num, sign);
    }

    /**
     * Main function to convert string to integer
     *
     * @param s Input string
     * @return  Converted integer
     */
    static int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Handle optional sign
        int sign = 1;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Call recursive helper to process digits
        return helper(s, i, 0, sign);
    }
}
