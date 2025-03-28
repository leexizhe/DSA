package answers.a_arrays_hashing;

import static common.PrintArray.printArray;

public class A7ProductOfArrayExceptSelf {
    /**
     * Time Complexity: O(n)
     * - The array is traversed twice, once from left to right and once from right to left. Each traversal takes O(n).
     * - Therefore, the overall time complexity is O(n).
     *
     * Space Complexity: O(1) (excluding the output array)
     * - No additional arrays or data structures are used beyond the result array and a few integer variables.
     * - Thus, the space complexity is O(1).
     */
    public static int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int length = nums.length;
        int[] array = new int[length];

        // Step 1: Calculate the left products and store them in `array`
        for (int i = 0; i < length; i++) {
            array[i] = left; // Store the cumulative product from the left
            left *= nums[i]; // Update `left` to include nums[i]
        }

        // Step 2: Calculate the right products and multiply with the existing values in `array`
        for (int i = length - 1; i >= 0; i--) {
            array[i] *= right; // Multiply the cumulative product from the right
            right *= nums[i]; // Update `right` to include nums[i]
        }

        return array;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {-1, 1, 0, -3, 3};
        printArray(productExceptSelf(nums1));
        printArray(productExceptSelf(nums2));
    }
}
