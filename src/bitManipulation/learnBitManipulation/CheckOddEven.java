package bitManipulation.learnBitManipulation;

public class CheckOddEven {

    /**
     * Checks whether a number is odd using bit manipulation.
     *
     * @param n The number to check
     * @return true if the number is odd, false otherwise
     */
    public boolean isOdd(int n) {

        // Perform bitwise AND with 1
        // If result is 1 → number is odd
        // If result is 0 → number is even
        return (n & 1) == 1;
    }

}
