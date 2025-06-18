package answers.i_heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class I7FindMedianFromDataStream {
    /**
     * Key Techniques:
     * Two Heaps (MaxHeap + MinHeap) → Maintain balance between lower and upper halves.
     * ✅ MaxHeap stores smaller half, MinHeap stores larger half.
     * ✅ Easy to extend, efficient insert and read → commonly reused in percentile or sliding median problems.
     *
     * Time Complexity:
     * addNum: O(log n) → Heap insertion
     * findMedian: O(1) → Top of heaps gives direct access to median
     *
     * Space Complexity: O(n) → Store all elements in the two heaps
     */
    static class MedianFinder {
        private PriorityQueue<Integer> maxHeap; // Lower half (max on top)
        private PriorityQueue<Integer> minHeap; // Upper half (min on top)

        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());

            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println("Median: " + mf.findMedian()); // 1.5
        mf.addNum(3);
        System.out.println("Median: " + mf.findMedian()); // 2.0
    }
}
