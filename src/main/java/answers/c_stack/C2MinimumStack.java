package answers.c_stack;

import java.util.Stack;

public class C2MinimumStack {
    /**
     * Time Complexity:
     * - `push()` and `pop()` take O(1) time since they perform basic stack operations.
     * - `top()` and `getMin()` also operate in O(1) time due to direct access to stored values.
     * - Therefore, all operations run in constant time, O(1).
     *
     * Space Complexity: O(n)
     * - The space complexity is O(n) due to storing elements in both the main stack and the minStack.
     */
    static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        // Push element onto the stack and update minStack
        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        // Pop element from the stack and update minStack if necessary
        public void pop() {
            if (!stack.isEmpty()) {
                if (stack.peek().equals(minStack.peek())) {
                    minStack.pop();
                }
                stack.pop();
            }
        }

        // Get the top element of the stack
        public int top() {
            return stack.peek();
        }

        // Retrieve the minimum element in the stack
        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Output: -3
        minStack.pop();
        System.out.println(minStack.top()); // Output: 0
        System.out.println(minStack.getMin()); // Output: -2
    }
}
