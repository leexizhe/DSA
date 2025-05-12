package answers.b_two_pointers;

import static common.PrintArray.printArray;

public class B2TwoIntegerSumII {
    /**
     * Key Techniques:
     * ✅ Two-Pointer Approach → Efficiently finds target sum in a sorted array.
     * ✅ O(n) Time Complexity → Single-pass iteration.
     * ✅ O(1) Space Complexity → No extra storage required.
     *
     * Time Complexity: O(n)
     * Each element is processed at most once, ensuring linear efficiency.
     *
     * Space Complexity: O(1)
     * Only a few extra variables are used for tracking indices.
     */
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] {left + 1, right + 1}; // Return 1-based indices
            } else if (sum < target) {
                left++; // Move left pointer forward
            } else {
                right--; // Move right pointer backward
            }
        }

        return new int[] {-1, -1}; // Target not found
    }

    public static void main(String[] args) {
        int[] array1 = {2, 7, 11, 15};
        int[] array2 = {2, 3, 4};
        int[] array3 = {-1, 0};

        printArray(twoSum(array1, 9)); // Output: [1, 2]
        printArray(twoSum(array2, 6)); // Output: [1, 3]
        printArray(twoSum(array3, -1)); // Output: [1, 2]
    }
}
