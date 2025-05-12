package answers.d_binary_search;

import static common.PrintArray.printArray;

public class D1BinarySearch {
    /**
     * Key Techniques:
     * ✅ Divide and Conquer → Efficiently reduces search space.
     * ✅ O(log n) Time Complexity → Iteratively halves the search space.
     * ✅ O(1) Space Complexity → Performs in-place searches without extra memory.
     *
     * Time Complexity: O(log n)
     * We repeatedly halve the array, making the solution logarithmic.
     *
     * Space Complexity: O(1)
     * Uses only a few extra variables for search tracking.
     */
    private static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid integer overflow
            if (nums[mid] > target) {
                right = mid - 1; // Move left
            } else if (nums[mid] < target) {
                left = mid + 1; // Move right
            } else {
                return mid; // Found the target
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] array1 = {-1, 0, 3, 5, 9, 12};
        int[] array2 = {2, 4, 6, 8, 10};

        printArray(new int[] {search(array1, 9)}); // Output: 4
        printArray(new int[] {search(array1, 2)}); // Output: -1 (not found)
        printArray(new int[] {search(array2, 6)}); // Output: 2
    }
}
