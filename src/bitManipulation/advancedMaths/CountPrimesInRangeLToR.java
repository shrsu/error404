package bitManipulation.advancedMaths;

import java.util.ArrayList;

public class CountPrimesInRangeLToR {

    /*
     Function to count number of primes in each query range
     Input: List of queries [L, R]
     Output: List containing count of primes in each range
    */
    public ArrayList<Integer> primesInRange(ArrayList<int[]> queries) {

        // Handle edge case
        if (queries == null || queries.isEmpty()) {
            return new ArrayList<>();
        }


        // Step 1: Find maximum value among all queries
        // This determines size of sieve
        int maxVal = 0;

        for (int[] query : queries) {
            maxVal = Math.max(maxVal, query[1]);
        }


        // Step 2: Create sieve array
        // isPrime[i] = true means i is prime
        boolean[] isPrime = new boolean[maxVal + 1];

        // Initialize all numbers ≥ 2 as prime initially
        for (int i = 2; i <= maxVal; i++) {
            isPrime[i] = true;
        }


        // Step 3: Apply Sieve of Eratosthenes
        for (int p = 2; p * p <= maxVal; p++) {

            // If p is prime
            if (isPrime[p]) {

                // Mark all multiples of p as non-prime
                for (int multiple = p * p; multiple <= maxVal; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }


        // Step 4: Build prefix sum array
        // primeCount[i] = number of primes ≤ i
        int[] primeCount = new int[maxVal + 1];

        for (int i = 1; i <= maxVal; i++) {

            // carry forward previous count
            primeCount[i] = primeCount[i - 1];

            // if current number is prime, increment count
            if (isPrime[i]) {
                primeCount[i]++;
            }
        }


        // Step 5: Answer queries using prefix sum
        ArrayList<Integer> result = new ArrayList<>();

        for (int[] query : queries) {

            int L = query[0];
            int R = query[1];

            // Compute count of primes in range
            int count;

            if (L == 0)
                count = primeCount[R];
            else
                count = primeCount[R] - primeCount[L - 1];

            result.add(count);
        }

        return result;
    }
}
