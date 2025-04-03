package answers.c_stack;

import java.util.Stack;

public class C3EvaluateReversePolishNotation {
    /**
     * Time Complexity: O(n)
     * - The algorithm iterates through the input tokens once, processing each token in O(1) time.
     * - Therefore, the overall time complexity is O(n), where n is the number of tokens in the input array.
     *
     * Space Complexity: O(n)
     * - The space complexity is O(n) because we use a stack to store intermediate results.
     */
    private static int evalRPN(String[] tokens) {
        // Step 1: Use a stack to evaluate expressions
        Stack<Integer> stack = new Stack<>();

        // Step 2: Iterate through tokens
        for (String token : tokens) {
            if (token.equals("+")) {
                // Addition operation
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                // Subtraction operation
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (token.equals("/")) {
                // Division operation
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a); // Integer division
            } else if (token.equals("*")) {
                // Multiplication operation
                stack.push(stack.pop() * stack.pop());
            } else {
                // Push operand onto the stack
                stack.push(Integer.parseInt(token));
            }
        }

        // Step 3: Return the final result
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};

        System.out.println(evalRPN(tokens1)); // Output: 9
        System.out.println(evalRPN(tokens2)); // Output: 6
    }
}
