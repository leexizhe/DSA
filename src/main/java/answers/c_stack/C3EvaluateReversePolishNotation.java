package answers.c_stack;

import java.util.Stack;

public class C3EvaluateReversePolishNotation {
    /**
     * Key Techniques:
     * ✅ Stack → Efficiently evaluates postfix expressions.
     * ✅ O(n) Time Complexity → Single-pass processing of tokens.
     * ✅ O(n) Space Complexity → Stores operands during evaluation.
     *
     * Time Complexity: O(n)
     * Each token is processed once, making the solution linear.
     *
     * Space Complexity: O(n)
     * In the worst case, the stack holds all operands.
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Process each token
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int b = stack.pop(), a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int b = stack.pop(), a = stack.pop();
                    stack.push(a / b);
                }
                default -> stack.push(Integer.parseInt(token)); // Push numbers onto stack
            }
        }

        return stack.pop(); // Final result
    }

    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};

        System.out.println(evalRPN(tokens1)); // Output: 9
        System.out.println(evalRPN(tokens2)); // Output: 6
    }
}
