package recursionPatterns.tryAllOutcombos;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.isEmpty()) return res;

        // idx=0, expr empty, value=0, prev=0
        backtrack(num, target, 0, new StringBuilder(), 0L, 0L, res);
        return res;
    }

    /**
     * @param num    input digit string
     * @param target desired result
     * @param idx    current index in num to start forming the next operand
     * @param expr   expression being built
     * @param value  evaluated value of expr so far
     * @param prev   last operand contribution to value (signed), used to handle '*'
     * @param res    output list of valid expressions
     */
    private void backtrack(String num, long target, int idx, StringBuilder expr, long value, long prev, List<String> res) {

        // If we've consumed all digits, check if we reached target
        if (idx == num.length()) {
            if (value == target) res.add(expr.toString());
            return;
        }

        int lenBefore = expr.length(); // to undo changes (backtrack)

        // Try all possible splits: num[idx..i]
        for (int i = idx; i < num.length(); i++) {

            // No leading zeros: "0" allowed, but "05" not allowed
            if (i > idx && num.charAt(idx) == '0') break;

            long cur = Long.parseLong(num.substring(idx, i + 1));

            if (idx == 0) {
                // First number: it can't have an operator before it
                expr.append(cur);
                backtrack(num, target, i + 1, expr, cur, cur, res);
                expr.setLength(lenBefore); // undo
            } else {
                // Try '+'
                expr.append('+').append(cur);
                backtrack(num, target, i + 1, expr, value + cur, cur, res);
                expr.setLength(lenBefore);

                // Try '-'
                expr.append('-').append(cur);
                backtrack(num, target, i + 1, expr, value - cur, -cur, res);
                expr.setLength(lenBefore);

                // Try '*'
                // Fix precedence: remove prev, add prev*cur
                expr.append('*').append(cur);
                long newValue = value - prev + (prev * cur);
                backtrack(num, target, i + 1, expr, newValue, prev * cur, res);
                expr.setLength(lenBefore);
            }
        }
    }
}
