package answers.c_stack;

import java.util.Stack;

public class C1ValidParentheses {
    /**
     * Key Techniques:
     * ✅ Stack → Efficiently tracks opening brackets.
     * ✅ O(n) Time Complexity → Single-pass validation.
     * ✅ O(n) Space Complexity → Stores unmatched brackets in worst-case.
     *
     * Time Complexity: O(n)
     * We iterate through the string once, processing each character efficiently.
     *
     * Space Complexity: O(n)
     * In the worst case (all open brackets), we use O(n) stack space.
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // Step 1: Process each character in the string
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); // Push opening brackets
            } else {
                if (stack.isEmpty()) return false; // Unmatched closing bracket

                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false; // Mismatched brackets
                }
            }
        }

        return stack.isEmpty(); // Valid only if no unmatched brackets remain
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "{[]}";

        System.out.println(isValid(s1)); // Output: true
        System.out.println(isValid(s2)); // Output: true
        System.out.println(isValid(s3)); // Output: false
        System.out.println(isValid(s4)); // Output: true
    }
}
