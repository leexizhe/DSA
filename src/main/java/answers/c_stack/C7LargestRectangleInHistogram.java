package answers.c_stack;

import java.util.Stack;

public class C7LargestRectangleInHistogram {
    /**
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of elements in the input array `heights`.
     * This is because each element is processed at most twice—once pushed and once popped from the stack—making the operations linear.
     *
     * Space Complexity: O(n)
     * The space complexity of this solution is O(n), since we use a stack to store indices of histogram bars.
     * In the worst case, all elements may be stored in the stack.
     */
    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i]; // Handle last element safely

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        int[] heights2 = {2, 4};
        int[] heights3 = {1, 1, 1, 1, 1};

        System.out.println(largestRectangleArea(heights1)); // Output: 10
        System.out.println(largestRectangleArea(heights2)); // Output: 4
        System.out.println(largestRectangleArea(heights3)); // Output: 5
    }
}
