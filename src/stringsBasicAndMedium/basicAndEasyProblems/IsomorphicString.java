package stringsBasicAndMedium.basicAndEasyProblems;

public class IsomorphicString {

    /**
     * Checks whether two strings are isomorphic.
     *
     * @param s first input string
     * @param t second input string
     * @return true if strings are isomorphic, false otherwise
     */
    public boolean isomorphicString(String s, String t) {
        // Arrays to store last seen positions of characters in s and t
        int[] lastSeenS = new int[256];
        int[] lastSeenT = new int[256];

        int n = s.length();

        // Traverse both strings simultaneously
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If last seen positions do not match, mapping is inconsistent
            if (lastSeenS[c1] != lastSeenT[c2]) {
                return false;
            }

            // Update last seen positions (i + 1 to avoid default zero conflict)
            lastSeenS[c1] = i + 1;
            lastSeenT[c2] = i + 1;
        }

        // All mappings are consistent
        return true;
    }
}
