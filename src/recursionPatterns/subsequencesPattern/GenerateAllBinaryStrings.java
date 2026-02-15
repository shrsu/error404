package recursionPatterns.subsequencesPattern;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinaryStrings {

    public List<String> generateAllBinaryStrings(int n) {
        List<String> ans = new ArrayList<>();
        helper("", n, ans);
        return ans;
    }

    private void helper(String current, int n, List<String> ans) {

        if (current.length() == n) {
            ans.add(current);
            return;
        }

        // Always place '0'
        helper(current + "0", n, ans);

        // Place '1' only if previous is not '1'
        if (current.length() == 0 || current.charAt(current.length() - 1) != '1') {
            helper(current + "1", n, ans);
        }
    }
}
