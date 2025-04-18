package answers.d_binary_search;

import static common.PrintArray.printArray;

public class D1BinarySearch {
    /**
     * Time Complexity: O(log n)
     * The time complexity of this solution is O(log n), where n is the number of elements in the input array `nums`.
     * This is because in each iteration, the search space is reduced by half.
     *
     * Space Complexity: O(1)
     * The space complexity of this solution is O(1), since no extra storage is used, only a few variables.
     */
    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // Perform binary search
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

        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] array1 = {-1, 0, 3, 5, 9, 12};
        int[] array2 = {2, 4, 6, 8, 10};

        printArray(new int[] {search(array1, 9)}); // Output: 4
        printArray(new int[] {search(array1, 2)}); // Output: -1 (not found)
        printArray(new int[] {search(array2, 6)}); // Output: 2
    }
}
