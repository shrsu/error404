package stringsBasicAndMedium.basicAndEasyProblems;

public class CheckIfOneStringIsRotationOfAnother {

    /**
     * Checks whether one string is a rotation of another.
     *
     * @param s     original string
     * @param goal  target string
     * @return true if goal is a rotation of s, false otherwise
     */
    public boolean rotateString(String s, String goal) {
        // Lengths must be equal for rotation to be possible
        if (s.length() != goal.length()) {
            return false;
        }

        // Concatenate the string with itself
        String doubled = s + s;

        // Check if goal exists as a substring
        return doubled.contains(goal);
    }
}
