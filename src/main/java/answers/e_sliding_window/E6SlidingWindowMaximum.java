package answers.e_sliding_window;

import static common.PrintArray.printArray;

import java.util.Deque;
import java.util.LinkedList;

public class E6SlidingWindowMaximum {
    /**
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of elements in the input array `nums`.
     * We iterate through the array only once, and each element is added and removed from the deque at most once.
     *
     * Space Complexity: O(k)
     * The space complexity is O(k), where k is the size of the sliding window.
     * The deque stores at most k elements at any given time.
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove elements outside the window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements from the back that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index to the deque
            deque.offerLast(i);

            // Store result when the window reaches size k
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
