package bitManipulation.learnBitManipulation;

public class SwapTwoNumbers {

    /**
     * Swaps two numbers using XOR without using a temporary variable.
     *
     * @param arr An array containing two integers to be swapped
     *            arr[0] = first number
     *            arr[1] = second number
     */
    public void swapXOR(int[] arr) {

        // Step 1: Store XOR of both numbers in arr[0]
        arr[0] = arr[0] ^ arr[1];

        // Step 2: Recover original arr[0] into arr[1]
        arr[1] = arr[0] ^ arr[1];

        // Step 3: Recover original arr[1] into arr[0]
        arr[0] = arr[0] ^ arr[1];
    }

}
