package stringsBasicAndMedium.mediumStringProblems;

import java.util.HashMap;
import java.util.Map;

public class RomanNumberToIntegerAndViceVersa {
    public int romanToInt(String s) {
        int result = 0;

        // Map to store Roman numeral values
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        // Iterate through the string except the last character
        for (int i = 0; i < s.length() - 1; i++) {
            int current = roman.get(s.charAt(i));
            int next = roman.get(s.charAt(i + 1));

            // If current value is smaller than next, subtract it
            if (current < next) {
                result -= current;
            }
            // Otherwise, add it
            else {
                result += current;
            }
        }

        // Add the value of the last character
        result += roman.get(s.charAt(s.length() - 1));

        return result;
    }

    public String intToRoman(int num) {
        // Value-symbol pairs in descending order
        int[] values = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1
        };

        String[] symbols = {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"
        };

        StringBuilder result = new StringBuilder();

        // Iterate over all value-symbol pairs
        for (int i = 0; i < values.length; i++) {
            // Append symbol while the value fits into num
            while (num >= values[i]) {
                num -= values[i];
                result.append(symbols[i]);
            }
        }

        return result.toString();
    }
}
