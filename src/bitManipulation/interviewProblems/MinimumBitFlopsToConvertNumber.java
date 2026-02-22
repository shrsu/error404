package bitManipulation.interviewProblems;

public class MinimumBitFlopsToConvertNumber {
    public int minBitFlips(int start, int goal) {

        // Step 1: XOR start and goal
        // This gives 1 at positions where bits differ
        int xor = start ^ goal;

        int count = 0;

        // Step 2: Check each bit position (0 to 30)
        // Since constraint is up to 10^9 → max 30 bits needed
        for (int i = 0; i < 31; i++) {

            // Check if ith bit is set
            if ((xor & (1 << i)) != 0) {
                count++;
            }
        }

        // Step 3: Return total flips required
        return count;
    }
}
