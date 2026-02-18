package recursionPatterns.subsequencesPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {

        // Map each digit to its corresponding letters
        Map<Integer, String> digitLettersMap = new HashMap<>();
        digitLettersMap.put(2, "abc");
        digitLettersMap.put(3, "def");
        digitLettersMap.put(4, "ghi");
        digitLettersMap.put(5, "jkl");
        digitLettersMap.put(6, "mno");
        digitLettersMap.put(7, "pqrs");
        digitLettersMap.put(8, "tuv");
        digitLettersMap.put(9, "wxyz");

        // Result list
        List<String> ans = new ArrayList<>();

        // Edge case: empty input
        if (digits == null || digits.length() == 0) {
            return ans;
        }

        // StringBuilder to build combinations
        StringBuilder current = new StringBuilder();

        // Start backtracking
        findCombinations(digits, ans, digitLettersMap, 0, current);

        return ans;
    }


    /**
     * Backtracking function to generate combinations
     *
     * @param digits          input digits string
     * @param ans             result list
     * @param digitLettersMap mapping of digit to letters
     * @param indx            current index in digits
     * @param current         current combination being built
     */
    private void findCombinations(String digits, List<String> ans, Map<Integer, String> digitLettersMap, int indx, StringBuilder current) {

        // Base case: full combination formed
        if (indx == digits.length()) {
            ans.add(current.toString());
            return;
        }

        // Get letters corresponding to current digit
        String currentSequence = digitLettersMap.get(digits.charAt(indx) - '0');

        // Try each letter
        for (int i = 0; i < currentSequence.length(); i++) {

            // Choose letter
            current.append(currentSequence.charAt(i));

            // Recurse to next digit
            findCombinations(digits, ans, digitLettersMap, indx + 1, current);

            // Backtrack: remove last letter
            current.deleteCharAt(current.length() - 1);
        }
    }
}

