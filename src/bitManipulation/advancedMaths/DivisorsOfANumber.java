package bitManipulation.advancedMaths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivisorsOfANumber {

    // Function to return all divisors in ascending order
    public List<Integer> getDivisors(int N) {

        // Step 1: Create list to store divisors
        List<Integer> res = new ArrayList<>();


        // Step 2: Loop from 1 to sqrt(N)
        for (int i = 1; i * i <= N; i++) {

            // Step 3: Check if i is divisor
            if (N % i == 0) {

                // Add first divisor
                res.add(i);

                // Step 4: Add paired divisor if different
                if (i != N / i) {
                    res.add(N / i);
                }
            }
        }


        // Step 5: Sort divisors in ascending order
        Collections.sort(res);

        return res;
    }
}