package stringsBasicAndMedium.basicAndEasyProblems;

public class CheckIfToStringsAreAnagramOfEachOther {

    /**
     * Checks whether t is an anagram of s.
     *
     * @param s first string
     * @param t second string
     * @return true if t is an anagram of s, false otherwise
     */
    public boolean isAnagram(String s, String t) {
        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency array for 26 lowercase letters
        int[] freq = new int[26];

        // Count characters in s
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Subtract character counts using t
        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
        }

        // Check if all counts are zero
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
