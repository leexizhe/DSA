package answers.arrays_hashing;

import static common.PrintArray.printArray;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    private static int[] topKFrequent(int[] nums, int k) {
        /**
         * Time Complexity: O(n * log k)
         * Counting the frequency of each element in the array takes O(n) time, where n is the number of elements in the array.
         * Constructing the Min Heap takes O(n * log k) time because we are adding each element to the heap and maintaining its size at most K.
         * Building the result array takes O(k * log k) time because we extract each element from the heap (at most K times).
         * Therefore, the overall time complexity is O(n + (n * log k) + (k * log k)), which simplifies to O(n * log k) since K is usually much smaller than n.
         *
         * Space Complexity: O(n + k)
         * The space complexity of this solution is O(n) for storing the frequency of each element in the HashMap and O(k) for maintaining the Min Heap.
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (int key : map.keySet()) {
            heap.offer(key);
        }

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = heap.poll();
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {1};

        printArray(topKFrequent(nums1, 2));
        printArray(topKFrequent(nums2, 1));
    }
}
