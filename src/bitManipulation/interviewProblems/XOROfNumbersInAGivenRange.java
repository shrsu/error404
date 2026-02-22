package bitManipulation.interviewProblems;

public class XOROfNumbersInAGivenRange {

    /*
     Function to compute XOR from 1 to n
     Based on repeating pattern every 4 numbers
    */
    private int XORtillN(int n) {

        // Case 1: n % 4 == 0 → result = n
        if (n % 4 == 0)
            return n;

        // Case 2: n % 4 == 1 → result = 1
        if (n % 4 == 1)
            return 1;

        // Case 3: n % 4 == 2 → result = n + 1
        if (n % 4 == 2)
            return n + 1;

        // Case 4: n % 4 == 3 → result = 0
        return 0;
    }


    /*
     Function to compute XOR from L to R
     Formula:
     XOR(L to R) = XOR(1 to R) ^ XOR(1 to L-1)
    */
    public int findRangeXOR(int l, int r) {

        return XORtillN(r) ^ XORtillN(l - 1);
    }
}
