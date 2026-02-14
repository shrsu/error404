package recursionPatterns.getAStrongHold;

public class PowOfXN {

    /*
     * ============================================================
     * Method 1: Brute Force
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * ============================================================
     */
    public double myPowBrute(double x, int n) {

        // x^0 = 1
        if (n == 0) {
            return 1.0;
        }

        // Convert to long to avoid overflow when n = Integer.MIN_VALUE
        long exponent = n;

        // Handle negative exponent
        if (exponent < 0) {
            x = 1 / x;
            exponent = -exponent;
        }

        double result = 1.0;

        // Multiply x exponent times
        for (long i = 0; i < exponent; i++) {
            result *= x;
        }

        return result;
    }


    /*
     * ============================================================
     * Method 2: Recursive Binary Exponentiation
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     * ============================================================
     */
    public double myPowRecursive(double x, int n) {

        long exponent = n;

        // Handle negative exponent
        if (exponent < 0) {
            return 1.0 / powerRecursive(x, -exponent);
        }

        return powerRecursive(x, exponent);
    }

    /*
     * Helper recursive function
     */
    private double powerRecursive(double x, long n) {

        // Base case
        if (n == 0) {
            return 1.0;
        }

        // If even exponent
        if (n % 2 == 0) {
            return powerRecursive(x * x, n / 2);
        }

        // If odd exponent
        return x * powerRecursive(x, n - 1);
    }


    /*
     * ============================================================
     * Method 3: Iterative Binary Exponentiation (BEST METHOD)
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * ============================================================
     */
    public double myPowIterative(double x, int n) {

        long exponent = n;

        // Handle negative exponent
        if (exponent < 0) {
            x = 1 / x;
            exponent = -exponent;
        }

        double result = 1.0;

        while (exponent > 0) {

            // If exponent is odd, multiply result
            if ((exponent & 1) == 1) {
                result *= x;
            }

            // Square the base
            x *= x;

            // Divide exponent by 2
            exponent >>= 1;
        }

        return result;
    }
}

