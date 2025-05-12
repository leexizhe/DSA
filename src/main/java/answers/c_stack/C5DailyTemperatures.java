package answers.c_stack;

import static common.PrintArray.printArray;

import java.util.Stack;

public class C5DailyTemperatures {
    /**
     * Key Techniques:
     * ✅ Monotonic Decreasing Stack → Tracks indices of previous temperatures.
     * ✅ O(n) Time Complexity → Each index is pushed and popped at most once.
     * ✅ O(n) Space Complexity → Worst-case stack storage when no warmer days appear.
     *
     * Time Complexity: O(n)
     * Each element is processed once, optimizing performance.
     *
     * Space Complexity: O(n)
     * Worst case is storing all elements when temperatures never increase.
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Step 1: Traverse the temperatures array
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index; // Calculate days until warmer temperature
            }
            stack.push(i); // Store current index
        }

        return result;
    }

    public static void main(String[] args) {
        int[] temps1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temps2 = {30, 40, 50, 60};
        int[] temps3 = {30, 60, 90};

        printArray(dailyTemperatures(temps1));
        printArray(dailyTemperatures(temps2));
        printArray(dailyTemperatures(temps3));
    }
}
