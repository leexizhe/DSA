package answers.c_stack;

import java.util.ArrayList;
import java.util.List;

public class C4GenerateParentheses {
    /**
     * Time Complexity: O(2^n)
     * - The recursive backtracking approach generates all valid parentheses combinations.
     * - Given that each position can be an opening or closing bracket, the complexity is exponential.
     *
     * Space Complexity: O(n)
     * - The space complexity is O(n) due to storing intermediate results in the recursive call stack.
     */
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private static void backtrack(List<String> list, String str, int open, int close, int max) {
        // Base case: If current string length matches required length, add to result
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        // Add an open parenthesis if count permits
        if (open < max) {
            backtrack(list, str + "(", open + 1, close, max);
        }

        // Add a close parenthesis if valid
        if (close < open) {
            backtrack(list, str + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 1;

        System.out.println(generateParenthesis(n1)); // Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
        System.out.println(generateParenthesis(n2));
    }
}
