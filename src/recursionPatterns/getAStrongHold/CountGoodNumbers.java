package recursionPatterns.getAStrongHold;

public class CountGoodNumbers {

    static final long MOD = 1_000_000_007;

    // ================================
    // Recursive Fast Exponentiation
    // ================================
    private static long powerRecursive(long base, long exp) {

        // Base case
        if (exp == 0)
            return 1;

        long half = powerRecursive(base, exp / 2);

        long result = (half * half) % MOD;

        // If exponent is odd
        if (exp % 2 == 1)
            result = (result * base) % MOD;

        return result;
    }

    public static int countGoodNumbersRecursive(long n) {

        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenPart = powerRecursive(5, evenCount);
        long oddPart = powerRecursive(4, oddCount);

        return (int)((evenPart * oddPart) % MOD);
    }


    // ================================
    // Iterative Fast Exponentiation
    // ================================
    private static long powerIterative(long base, long exp) {

        long result = 1;

        while (exp > 0) {

            // If exponent is odd
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exp = exp >> 1;
        }

        return result;
    }

    public static int countGoodNumbersIterative(long n) {

        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenPart = powerIterative(5, evenCount);
        long oddPart = powerIterative(4, oddCount);

        return (int)((evenPart * oddPart) % MOD);
    }
}

