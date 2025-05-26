package answers.i_heap;

import java.util.PriorityQueue;

public class I4KthLargestElementInArray {
    /**
     * Key Techniques:
     * ✅ MinHeap for Efficient Kth Largest Tracking → Keeps only K largest elements.
     * ✅ O(n log k) Time Complexity → Maintains efficient heap operations.
     * ✅ Handles Large Inputs → Dynamically finds Kth largest element without sorting everything.
     *
     * Time Complexity: O(n log k)
     * Each `add()` operation runs in **O(log k)** due to heap insertion/removal.
     *
     * Space Complexity: O(k)
     * The heap only stores k elements, making it space-efficient.
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest, keeping k largest elements
            }
        }

        return minHeap.peek(); // Kth largest element remains at the top
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Kth Largest Element: " + findKthLargest(nums, k)); // Output: 5
    }
}
