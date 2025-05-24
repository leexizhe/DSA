package answers.e_sliding_window;

import java.util.Deque;
import java.util.LinkedList;

public class E7LongestSubarrayWithLimit {
    /**
     * Key Techniques:
     * ✅ Sliding Window + Monotonic Deque → Efficiently tracks min/max values.
     * ✅ O(n) Time Complexity → Maintains the longest valid subarray in linear time.
     * ✅ Handles Edge Cases → Works with varying constraints and large inputs.
     *
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of elements.
     * Each element is added/removed from the deque at most once, ensuring linear complexity.
     *
     * Space Complexity: O(n)
     * The space complexity is O(n) in the worst case, where all elements need to be stored in both deques.
     */
    public static int longestSubarray(int[] nums, int limit) {
        int left = 0, maxLength = 0;
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        for (int right = 0; right < nums.length; right++) {
            // Maintain decreasing maxDeque
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(nums[right]);

            // Maintain increasing minDeque
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(nums[right]);

            // Shrink window if difference exceeds limit
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() && maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                // Ensures maxDeque.peekFirst() is always the actual max in the window
                if (maxDeque.peekFirst() == nums[left]) {
                    maxDeque.pollFirst();
                }
                // Ensures minDeque.peekFirst() is always the actual min in the window
                if (minDeque.peekFirst() == nums[left]) {
                    minDeque.pollFirst();
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {8, 2, 4, 7};
        int limit = 4;
        System.out.println("Longest Subarray Length: " + longestSubarray(nums, limit));
    }
}
