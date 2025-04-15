package answers.c_stack;

import static common.PrintArray.printArray;

import java.util.Stack;

public class C5DailyTemperatures {
    /**
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of elements in the input array `temperatures`.
     * This is because each element is pushed onto the stack at most once and popped at most once, making the operations linear.
     *
     * Space Complexity: O(n)
     * The space complexity of this solution is O(n), as we use a stack to store indices of temperatures.
     * In the worst case, we store all the elements in the stack.
     */
    private static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index; // Calculate the number of days until a warmer temperature
            }
            stack.push(i);
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
