package answers.arrays_hashing;

import static common.PrintArray.printArray;

import java.util.*;

public class A5TopKFrequentElements {
    /**
     * Time Complexity: O(n)
     * - Counting the frequency of elements takes O(n), where `n` is the number of elements in the array `nums`.
     * - Placing elements into buckets and retrieving the top k frequent elements both take O(n).
     * - The total time complexity is O(n), as no sorting or heap operations are required.
     *
     * Space Complexity: O(n)
     * - The space complexity is O(n) because of the HashMap and the bucket list, which together grow linearly with the input size.
     */
    private static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create aaray to store elements with the same frequency
        // The size of the bucket array is nums.length + 1 because the maximum possible frequency of any element is
        // nums.length.
        List<Integer>[] aaray = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            if (aaray[frequency] == null) {
                aaray[frequency] = new ArrayList<>();
            }
            aaray[frequency].add(entry.getKey());
        }

        // Step 3: Collect the top k frequent elements
        int[] res = new int[k];
        int index = 0; // Declared outside the loop
        for (int i = aaray.length - 1; i > 0 && index < k; i--) {
            if (aaray[i] != null) {
                for (int n : aaray[i]) {
                    res[index++] = n;
                    if (index == k) { // Break if the result array is fully populated
                        return res;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3};
        int[] nums2 = {7, 7};

        printArray(topKFrequent(nums1, 2));
        printArray(topKFrequent(nums2, 1));
    }
}
