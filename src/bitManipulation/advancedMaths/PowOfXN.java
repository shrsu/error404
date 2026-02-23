package bitManipulation.advancedMaths;

public class PowOfXN {

    /**
     * Iterative binary exponentiation
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public double myPow(double x, int n) {

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
