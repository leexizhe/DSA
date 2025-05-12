package answers.c_stack;

import java.util.ArrayList;
import java.util.List;

public class C4GenerateParentheses {
    /**
     * Key Techniques:
     * ✅ Backtracking → Efficiently builds valid sequences.
     * ✅ O(4^n / sqrt(n)) Time Complexity → Based on Catalan number complexity.
     * ✅ O(n) Space Complexity → Recursive stack depth scales with n.
     *
     * Time Complexity: O(4^n / sqrt(n))
     * The complexity is derived from the number of valid sequences that can be generated.
     *
     * Space Complexity: O(n)
     * The recursion stack depth scales with the number of pairs `n`.
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 1;

        System.out.println(generateParenthesis(n1)); // Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
        System.out.println(generateParenthesis(n2));
    }
}
