package bitManipulation.learnBitManipulation;

public class BitManipulationIntroduction {

    /*
     * ------------------------------------------------------------
     * 1. Decimal to Binary Conversion
     * ------------------------------------------------------------
     * Converts a decimal number to binary string.
     */
    public static String decimalToBinary(int num) {
        if (num == 0) return "0";

        StringBuilder binary = new StringBuilder();

        while (num > 0) {
            int remainder = num % 2;
            binary.append(remainder);
            num = num / 2;
        }

        return binary.reverse().toString();
    }

    /*
     * ------------------------------------------------------------
     * 2. Binary to Decimal Conversion
     * ------------------------------------------------------------
     * Converts binary string to decimal number.
     */
    public static int binaryToDecimal(String binary) {
        int result = 0;
        int power = 0;

        for (int i = binary.length() - 1; i >= 0; i--) {
            int bit = binary.charAt(i) - '0';
            result += bit * (1 << power);
            power++;
        }

        return result;
    }

    /*
     * ------------------------------------------------------------
     * 3. One's Complement
     * ------------------------------------------------------------
     * Flips all bits of the number.
     */
    public static int onesComplement(int num) {
        return ~num;
    }

    /*
     * ------------------------------------------------------------
     * 4. Two's Complement
     * ------------------------------------------------------------
     * Two's complement = one's complement + 1
     */
    public static int twosComplement(int num) {
        return ~num + 1;
    }

    /*
     * ------------------------------------------------------------
     * 5. Bitwise AND
     */
    public static int bitwiseAND(int a, int b) {
        return a & b;
    }

    /*
     * ------------------------------------------------------------
     * 6. Bitwise OR
     */
    public static int bitwiseOR(int a, int b) {
        return a | b;
    }

    /*
     * ------------------------------------------------------------
     * 7. Bitwise XOR
     */
    public static int bitwiseXOR(int a, int b) {
        return a ^ b;
    }

    /*
     * ------------------------------------------------------------
     * 8. Bitwise NOT
     */
    public static int bitwiseNOT(int num) {
        return ~num;
    }

    /*
     * ------------------------------------------------------------
     * 9. Left Shift
     * Multiplies number by 2^positions
     */
    public static int leftShift(int num, int positions) {
        return num << positions;
    }

    /*
     * ------------------------------------------------------------
     * 10. Right Shift
     * Divides number by 2^positions
     */
    public static int rightShift(int num, int positions) {
        return num >> positions;
    }

    /*
     * ------------------------------------------------------------
     * 11. Check if i-th Bit is Set
     */
    public static boolean isBitSet(int num, int i) {
        return ((num >> i) & 1) == 1;
    }

    /*
     * ------------------------------------------------------------
     * 12. Set i-th Bit
     */
    public static int setBit(int num, int i) {
        return num | (1 << i);
    }

    /*
     * ------------------------------------------------------------
     * 13. Clear i-th Bit
     */
    public static int clearBit(int num, int i) {
        return num & ~(1 << i);
    }

    /*
     * ------------------------------------------------------------
     * 14. Toggle i-th Bit
     */
    public static int toggleBit(int num, int i) {
        return num ^ (1 << i);
    }

    /*
     * ------------------------------------------------------------
     * 15. Swap Two Numbers Using XOR
     */
    public static void swapUsingXOR(int a, int b) {
        System.out.println("Before swap: a = " + a + ", b = " + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("After swap: a = " + a + ", b = " + b);
    }

}
