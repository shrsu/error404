package bitManipulation.learnBitManipulation;

public class CheckPowerOfTwo {

    /**
     * Checks whether a number is a power of two using bit manipulation.
     *
     * @param n The number to check
     * @return true if n is a power of two, false otherwise
     */
    public boolean isPowerOfTwo(int n) {

        // Power of two numbers:
        // 1. Must be greater than 0
        // 2. Must have exactly one bit set
        // n & (n - 1) removes the lowest set bit
        // If result is 0, only one bit was set

        return n > 0 && (n & (n - 1)) == 0;
    }

}
