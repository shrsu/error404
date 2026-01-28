package stringsBasicAndMedium.mediumStringProblems;

public class ImplementAtoi {

    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        int sign = 1;
        long result = 0; // use long to detect overflow before casting

        // 1) Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2) If string contains only spaces, return 0
        if (i == n) {
            return 0;
        }

        // 3) Optional sign
        char c = s.charAt(i);
        if (c == '-') {
            sign = -1;
            i++;
        } else if (c == '+') {
            i++;
        }

        // 4) Parse digits and build the number
        while (i < n) {
            char ch = s.charAt(i);
            if (!Character.isDigit(ch)) {
                break; // stop at first non-digit
            }

            int digit = ch - '0';
            result = result * 10 + digit;

            // 5) Early clamp to avoid overflow when applying sign
            long signed = sign * result;
            if (signed > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (signed < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (sign * result);
    }
}
