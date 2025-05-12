package answers.c_stack;

import java.util.Stack;

public class C7LargestRectangleInHistogram {
    /**
     * Key Techniques:
     * ✅ Monotonic Increasing Stack → Tracks previous heights efficiently.
     * ✅ O(n) Time Complexity → Each bar is pushed and popped once.
     * ✅ O(n) Space Complexity → Worst-case stack storage.
     *
     * Time Complexity: O(n)
     * Each height is processed once, ensuring optimal performance.
     *
     * Space Complexity: O(n)
     * Worst case occurs when stack holds all histogram bars.
     */
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        // Step 1: Iterate through heights, maintaining a monotonic increasing stack
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];

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
