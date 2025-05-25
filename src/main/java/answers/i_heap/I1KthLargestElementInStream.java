package answers.i_heap;

import java.util.PriorityQueue;

public class I1KthLargestElementInStream {
    /**
     * Key Techniques:
     * ✅ MinHeap for Efficient Kth Largest Tracking → Keeps only K largest elements.
     * ✅ O(log k) Time Complexity per Insert → Maintains efficient updates.
     * ✅ Handles Continuous Stream Updates → Dynamically adjusts kth largest element.
     *
     * Time Complexity: O(log k)
     * Each `add()` operation runs in O(log k) due to heap insertion and removal.
     * Space Complexity: O(k)
     * The heap only stores k elements, making it space-efficient.
     */
    static class KthLargest {
        private final PriorityQueue<Integer> minHeap;
        private final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.minHeap = new PriorityQueue<>();

            // Initialize heap with first k elements
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            minHeap.offer(val);

            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest, keep k largest
            }

            return minHeap.peek(); // Kth largest element
        }
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] {4, 5, 8, 2});
        System.out.println(kthLargest.add(3)); // Output: 4
        System.out.println(kthLargest.add(5)); // Output: 5
        System.out.println(kthLargest.add(10)); // Output: 5
        System.out.println(kthLargest.add(9)); // Output: 8
        System.out.println(kthLargest.add(4)); // Output: 8
    }
}
