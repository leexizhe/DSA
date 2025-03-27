package answers.arrays_hashing;

import java.util.HashSet;
import java.util.Set;

public class A9LongestConsecutiveSequence {
    /**
     * Time Complexity: O(n)
     * - The array is traversed once to insert elements into a `HashSet`, which takes O(n).
     * - Each element is then checked to find the starting point of a sequence, and each sequence is processed once.
     * - Therefore, the overall time complexity is O(n).
     *
     * Space Complexity: O(n)
     * - A `HashSet` is used to store all elements of the input array, requiring O(n) space.
     * - The space complexity is proportional to the input size.
     */
    public static int longestConsecutive(int[] nums) {
        // Step 1: Add all numbers to a HashSet for O(1) lookup
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Step 2: Check for the start of a sequence
        for (int num : nums) {
            // Only start a sequence if the current number is the beginning
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Step 3: Count the length of the consecutive sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println(longestConsecutive(nums1)); // Output: 4 (sequence: 1, 2, 3, 4)
        System.out.println(longestConsecutive(nums2)); // Output: 9 (sequence: 0, 1, 2, 3, 4, 5, 6, 7, 8)
    }
}
