package bitManipulation.learnBitManipulation;

public class CountSetBits {

    /**
     * Counts the number of set bits (1s) in the binary representation of n
     * using Brian Kernighan's Algorithm.
     *
     * @param n The number whose set bits need to be counted
     * @return The number of set bits
     */
    public int countSetBits(int n) {

        // Variable to store the count of set bits
        int count = 0;

        // Loop until n becomes 0
        while (n > 0) {

            // Remove the rightmost set bit from n
            n = n & (n - 1);

            // Increment the count
            count++;
        }

        // Return the total number of set bits
        return count;
    }

}
