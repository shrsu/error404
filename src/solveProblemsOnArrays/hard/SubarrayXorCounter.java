package solveProblemsOnArrays.hard;

import java.util.HashMap;
import java.util.Map;

public class SubarrayXorCounter {

    /**
     * Counts the number of subarrays whose XOR is equal to k.
     *
     * @param A input array
     * @param k target XOR value
     * @return number of subarrays with XOR equal to k
     */
    public int countSubarrays(int[] A, int k) {

        // Map to store frequency of prefix XOR values
        Map<Integer, Integer> prefixXorFreq = new HashMap<>();

        // Base case: prefix XOR = 0 occurs once
        prefixXorFreq.put(0, 1);

        int prefixXor = 0;
        int count = 0;

        // Traverse the array
        for (int num : A) {

            // Update running prefix XOR
            prefixXor ^= num;

            // Required prefix XOR to form XOR = k
            int target = prefixXor ^ k;

            // If target exists, add its frequency to result
            if (prefixXorFreq.containsKey(target)) {
                count += prefixXorFreq.get(target);
            }

            // Update frequency of current prefix XOR
            prefixXorFreq.put(
                    prefixXor,
                    prefixXorFreq.getOrDefault(prefixXor, 0) + 1
            );
        }

        return count;
    }
}
