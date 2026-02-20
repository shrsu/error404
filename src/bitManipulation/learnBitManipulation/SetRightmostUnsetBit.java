package bitManipulation.learnBitManipulation;

public class SetRightmostUnsetBit {

    /**
     * Sets the rightmost unset bit (0) in the binary representation of n.
     * If all bits are already set, returns n unchanged.
     *
     * @param n The input number
     * @return The number after setting the rightmost unset bit
     */
    public static int setRightmostUnsetBit(int n) {

        // Check if all bits are already set
        if ((n & (n + 1)) == 0) {
            return n;
        }

        // Set the rightmost unset bit using OR
        return n | (n + 1);
    }

}
