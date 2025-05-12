package answers.a_arrays_hashing;

import java.util.HashSet;

public class A9LongestConsecutiveSequence {
    /**
     * Key Techniques:
     * ✅ HashSet → Enables O(1) lookups for sequence continuity.
     * ✅ O(n) Time Complexity → Avoids sorting overhead.
     * ✅ O(n) Space Complexity → Stores unique elements efficiently.
     *
     * Time Complexity: O(n)
     * Each number is processed once, ensuring linear efficiency.
     *
     * Space Complexity: O(n)
     * Stores distinct elements in a hash set.
     */
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num); // Store unique numbers
        }

        int maxLength = 0;

        // Step 1: Traverse numbers and find sequence starts
        for (int num : nums) {
            if (!set.contains(num - 1)) { // Ensure we start only at sequence beginning
                int length = 1;
                while (set.contains(num + length)) {
                    length++;
                }
                maxLength = Math.max(maxLength, length); // Update max sequence length
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println(longestConsecutive(nums1)); // Output: 4 (sequence: 1, 2, 3, 4)
        System.out.println(longestConsecutive(nums2)); // Output: 9 (sequence: 0, 1, 2, 3, 4, 5, 6, 7, 8)
    }
}
