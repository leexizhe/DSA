package answers.c_stack;

import java.util.Stack;

public class C2MinimumStack {
    /**
     * Key Techniques:
     * ✅ Stack for push/pop operations.
     * ✅ Auxiliary Min Stack → Keeps track of minimum values.
     * ✅ O(1) Time Complexity → Fast retrieval of min element.
     *
     * Time Complexity:
     * - `push()` → O(1) (Constant time insertion)
     * - `pop()` → O(1) (Constant time removal)
     * - `top()` → O(1) (Constant time retrieval)
     * - `getMin()` → O(1) (Constant time min lookup)
     *
     * Space Complexity: O(n)
     * Stores all values efficiently with an auxiliary stack.
     */
    static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val); // Only push if it's the new minimum
            }
        }

        public void pop() {
            if (stack.isEmpty()) return;

            if (stack.peek().equals(minStack.peek())) {
                minStack.pop(); // Remove min value if it's being popped
            }
            stack.pop();
        }

        public int top() {
            return stack.isEmpty() ? -1 : stack.peek();
        }

        public int getMin() {
            return minStack.isEmpty() ? -1 : minStack.peek();
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
