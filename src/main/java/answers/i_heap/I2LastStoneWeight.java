package answers.i_heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class I2LastStoneWeight {
    /**
     * Key Techniques:
     * ✅ MaxHeap for Efficient Largest-Stone Tracking → Always processes the heaviest stones first.
     * ✅ O(n log n) Time Complexity → Heap operations ensure efficient smashing.
     * ✅ Handles Continuous Stone Reduction → Dynamically reduces stones until one remains.
     *
     * Time Complexity: O(n log n)
     * - Each `add()` operation runs in **O(log n)**.
     * - The loop runs **O(n) times**, leading to an overall complexity of **O(n log n)**.
     *
     * Space Complexity: O(n)
     * - Stores all stones in a **PriorityQueue**.
     */

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Insert all stones into the max heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Smash stones until one or none remains
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone1 > stone2) {
                maxHeap.offer(stone1 - stone2);
            }
        }

        // If there's a stone left, return its weight, otherwise return 0
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println("Last Stone Weight: " + lastStoneWeight(stones)); // Output: 1
    }
}