package answers.c_stack;

import java.util.HashMap;
import java.util.Stack;

public class C1ValidParentheses {
    /**
     * Time Complexity: O(n)
     * - The algorithm iterates through the string once, processing each character in O(1) time.
     * - Therefore, the overall time complexity is O(n).
     *
     * Space Complexity: O(n)
     * - In the worst case, the stack stores all opening brackets, requiring O(n) space.
     */
    private static boolean isValid(String s) {
        // Step 1: Create a mapping of closing to opening brackets
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        // Step 2: Use a stack to track opening brackets
        Stack<Character> stack = new Stack<>();

        // Step 3: Iterate through the characters in the string
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                // Check if the stack is empty or if the top element does not match the expected opening bracket
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                // Push opening brackets onto the stack
                stack.push(c);
            }
        }

        // Step 4: If the stack is empty, the parentheses are valid
        return stack.isEmpty();
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
