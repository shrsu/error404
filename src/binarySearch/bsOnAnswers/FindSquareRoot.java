package binarySearch.bsOnAnswers;

public class FindSquareRoot {

    /**
     * Returns the floor value of the square root of a given number.
     *
     * @param x the input number
     * @return floor value of sqrt(x)
     */
    public int mySqrt(int x) {

        // Handle base cases
        if (x < 2) {
            return x;
        }

        // Binary search range: [1, x / 2]
        int left = 1;
        int right = x / 2;
        int ans = 0;

        // Perform binary search
        while (left <= right) {

            // Calculate mid safely to avoid overflow
            long mid = left + (right - left) / 2;

            // Check if mid^2 is less than or equal to x
            if (mid * mid <= x) {
                ans = (int) mid;      // mid is a valid candidate
                left = (int) mid + 1; // try to find a larger valid value
            } else {
                right = (int) mid - 1; // mid is too large
            }
        }

        return ans;
    }
}
