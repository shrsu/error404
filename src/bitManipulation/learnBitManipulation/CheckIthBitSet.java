package bitManipulation.learnBitManipulation;

public class CheckIthBitSet {

    /**
     * Checks whether the i-th bit of integer n is set (1) or not (0).
     *
     * @param n The number whose bit needs to be checked
     * @param i The bit index (0-based from LSB)
     * @return true if the i-th bit is set, false otherwise
     */
    public boolean checkIthBit(int n, int i) {

        // Create a mask by left shifting 1 by i positions
        // Example: i = 2 → mask = 00000100
        int mask = 1 << i;

        // Perform bitwise AND between n and mask
        // If result is non-zero, the bit is set
        return (n & mask) != 0;
    }

}
