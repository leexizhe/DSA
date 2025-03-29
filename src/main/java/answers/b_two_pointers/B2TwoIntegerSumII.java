package answers.b_two_pointers;

import static common.PrintArray.printArray;

public class B2TwoIntegerSumII {
    /**
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of elements in the input array `numbers`.
     * This is because we iterate through the array once, using a two-pointer approach to find the solution.
     *
     * Space Complexity: O(1)
     * The space complexity of this solution is O(1), as no additional data structures are used beyond a few integer variables.
     */
    public static int[] twoSumII(int[] numbers, int target) {
        // Initialize two pointers
        int left = 0; // Start pointer
        int right = numbers.length - 1; // End pointer

        // Use the two-pointer approach
        while (left < right) {
            int sum = numbers[left] + numbers[right]; // Calculate the sum of the two numbers

            if (sum == target) {
                // Return indices if the sum equals the target (1-based index)
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                // Move the left pointer forward to increase the sum
                left++;
            } else {
                // Move the right pointer backward to decrease the sum
                right--;
            }
        }

        // Return an empty array if no solution is found
        return new int[0];
    }

    public static void main(String[] args) {
        int[] array1 = {2, 7, 11, 15};
        int[] array2 = {2, 3, 4};
        int[] array3 = {-1, 0};

        printArray(twoSumII(array1, 9)); // Output: [1, 2]
        printArray(twoSumII(array2, 6)); // Output: [1, 3]
        printArray(twoSumII(array3, -1)); // Output: [1, 2]
    }
}