package answers.i_heap;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class I5TaskScheduler {
    /**
     * Key Techniques:
     * ✅ MaxHeap for Task Frequency Tracking → Ensures the most frequent tasks are scheduled first.
     * ✅ O(n log n) Time Complexity → Efficient scheduling while handling cooling constraints.
     * ✅ Handles Idle Time → Dynamically adjusts scheduling gaps to ensure optimal CPU cycles.
     *
     * Time Complexity: O(n log n)
     * - Counting task frequencies runs in **O(n)**.
     * - Heap operations run in **O(log n)** per scheduling cycle.
     * - Overall complexity is **O(n log n)**.
     *
     * Space Complexity: O(n)
     * - Stores task frequencies in a **HashMap**.
     * - Uses a **MaxHeap** and queue to manage scheduling efficiently.
     */
    public static int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : counts) {
            if (count > 0) {
                maxHeap.add(count); // Only store non-zero counts
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll() - 1;
                if (count > 0) {
                    queue.add(new int[] {count, time + n}); // Enforce cooling period
                }
            }

            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.add(queue.poll()[0]); // Reinsert task after cooldown
            }
        }

        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println("Minimum CPU cycles: " + leastInterval(tasks, n)); // Output: 8
    }
}
