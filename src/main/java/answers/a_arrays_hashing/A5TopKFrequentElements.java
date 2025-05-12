package answers.a_arrays_hashing;

import static common.PrintArray.printArray;

import java.util.*;

public class A5TopKFrequentElements {
    /**
     * Key Techniques:
     * ✅ HashMap → Efficiently counts element frequencies.
     * ✅ Bucket Sort → Groups elements based on frequency.
     * ✅ O(n) Time Complexity → Avoids expensive sorting or heap operations.
     *
     * Time Complexity: O(n)
     * - Counting frequencies takes O(n).
     * - Bucket sorting ensures efficient grouping.
     *
     * Space Complexity: O(n)
     * Stores element frequencies and bucket data efficiently.
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
