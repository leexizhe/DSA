package answers.e_sliding_window;

import static common.PrintArray.printArray;

import java.util.Deque;
import java.util.LinkedList;

public class E6SlidingWindowMaximum {
    /**
     * Key Techniques:
     * ✅ Monotonic Deque → Efficiently maintains max values in the window.
     * ✅ O(n) Time Complexity → Processes elements in a single pass.
     * ✅ O(k) Space Complexity → Stores at most k elements in the deque.
     *
     * Time Complexity: O(n)
     * Each element is added and removed from the deque at most once, making it linear.
     *
     * Space Complexity: O(k)
     * The deque holds at most k elements, reducing unnecessary storage.
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        // Step 1: Iterate through the array while maintaining a monotonic deque
        for (int i = 0; i < nums.length; i++) {
            // Remove elements that are out of the window range
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Maintain decreasing order in deque by removing smaller values
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            // Step 2: Record max value once we have processed at least k elements
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] array2 = {9, 11, 8, 5, 7, 10};

        printArray(maxSlidingWindow(array1, 3)); // Output: [3, 3, 5, 5, 6, 7]
        printArray(maxSlidingWindow(array2, 2)); // Output: [11, 11, 8, 7, 10]
    }
}
