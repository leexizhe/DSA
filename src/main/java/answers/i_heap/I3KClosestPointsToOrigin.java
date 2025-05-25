package answers.i_heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class I3KClosestPointsToOrigin {
    /**
     * Key Techniques:
     * ✅ MinHeap for Efficient Closest Point Tracking → Keeps the closest n points based on distance.
     * ✅ O(n log n) Time Complexity → Efficient heap operations for sorting n closest points.
     * ✅ Handles Large Inputs → Dynamically selects n closest points without full sorting.
     *
     * Time Complexity: O(n log n)
     * Each `add()` operation runs in **O(log k)**, processing **n** points, leading to **O(n log n)** overall.
     *
     * Space Complexity: O(n)
     * The heap only stores n elements, optimizing memory usage.
     */
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1]; // Euclidean distance squared
            minHeap.offer(new int[] {dist, point[0], point[1]});
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; ++i) {
            int[] point = minHeap.poll();
            result[i] = new int[] {point[1], point[2]};
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        int[][] closest = kClosest(points, k);

        System.out.println("K Closest Points:");
        for (int[] point : closest) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}
