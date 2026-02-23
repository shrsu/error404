package bitManipulation.advancedMaths;

public class PrintPrimeFactorsOfANumber {

    public static void printPrimeFactors(int n) {

        // Edge case
        if (n <= 1) {
            System.out.println("No prime factors");
            return;
        }

        // Step 1: Extract all factors of 2 using bit manipulation
        while ((n & 1) == 0) {     // Check if even
            System.out.print(2 + " ");
            n >>= 1;               // Divide by 2 using shift
        }

        // Step 2: Check odd divisors from 3 to sqrt(n)
        for (int d = 3; (long)d * d <= n; d += 2) {

            while (n % d == 0) {
                System.out.print(d + " ");
                n /= d;
            }
        }

        // Step 3: If remaining n > 1, it is prime
        if (n > 1) {
            System.out.print(n);
        }

        System.out.println();
    }

}
