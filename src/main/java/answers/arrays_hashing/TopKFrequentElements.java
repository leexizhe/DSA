package answers.arrays_hashing;

import static common.PrintArray.printArray;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    private static int[] topKFrequent(int[] nums, int k) {
        // time O(n*log(n)) where n=Length of nums
        // space O(n)
        // hashmap and priority queue

        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            pq.add(mapEntry);
            if (pq.size() > k) pq.poll();
        }

        for (int i = 0; i < k; i++) ans[i] = pq.poll().getKey();

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {1};

        printArray(topKFrequent(nums1, 2));
        printArray(topKFrequent(nums2, 1));
    }
}
