package bitManipulation.learnBitManipulation;

public class DivideIntegersWithoutOperators {

    public int divide(int dividend, int divisor) {

        // Step 0: Special case
        // If both numbers are equal, result is always 1
        if (dividend == divisor)
            return 1;


        // Step 1: Determine sign of result
        // true  → positive result
        // false → negative result
        boolean sign = true;

        // If signs differ, result is negative
        if ((dividend >= 0 && divisor < 0) ||
                (dividend < 0 && divisor > 0)) {
            sign = false;
        }


        // Step 2: Convert to positive using long
        // Important: abs(INT_MIN) overflows int
        // long prevents overflow
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);


        // Step 3: Store quotient
        long quotient = 0;


        // Step 4: Division using bit shifting
        while (n >= d) {

            int cnt = 0;

            // Find largest power of 2 such that
            // (d * 2^(cnt+1)) <= n
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }

            // Add that power of 2 to quotient
            quotient += (1L << cnt);

            // Subtract the value from dividend
            n -= (d << cnt);
        }


        // Step 5: Handle overflow case
        // When quotient exceeds Integer.MAX_VALUE
        if (quotient == (1L << 31)) {

            if (sign)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }


        // Step 6: Apply sign and return result
        return sign ? (int) quotient : (int) -quotient;
    }
}
