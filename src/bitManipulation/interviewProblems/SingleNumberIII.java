package bitManipulation.interviewProblems;

public class SingleNumberIII {

    /*
     Returns the two numbers that appear only once.
     All other numbers appear exactly twice.
     Output must be in ascending order.
    */
    public int[] singleNumber(int[] nums) {

        // Step 1: XOR of all elements = a ^ b (where a and b are the unique numbers)
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Get the rightmost set bit mask of xor
        // This isolates a bit where a and b differ.
        // Example: xor = 1101000 -> mask = 0001000
        int mask = xor & -xor;

        // Step 3: Separate into two buckets and XOR within each bucket
        int x1 = 0; // will end up as one unique number
        int x2 = 0; // will end up as the other unique number

        for (int num : nums) {
            if ((num & mask) != 0) {
                // This bucket contains numbers with the chosen bit set
                x1 ^= num;
            } else {
                // This bucket contains numbers with the chosen bit not set
                x2 ^= num;
            }
        }

        // Step 4: Return in ascending order
        if (x1 < x2) return new int[]{x1, x2};
        return new int[]{x2, x1};
    }
}
