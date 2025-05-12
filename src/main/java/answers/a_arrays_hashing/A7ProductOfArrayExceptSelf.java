package answers.a_arrays_hashing;

import static common.PrintArray.printArray;

public class A7ProductOfArrayExceptSelf {
    /**
     * Key Techniques:
     * ✅ Prefix & Suffix Products → Avoids division operation.
     * ✅ O(n) Time Complexity → Efficient single-pass computation.
     * ✅ O(1) Space Complexity → Uses output array for in-place calculations.
     *
     * Time Complexity: O(n)
     * Two passes ensure efficient traversal without redundant computation.
     *
     * Space Complexity: O(1)
     * Uses output array for in-place product calculations.
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Compute prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Compute suffix products in-place
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix; // Multiply with suffix product
            suffix *= nums[i]; // Update suffix
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {-1, 1, 0, -3, 3};
        printArray(productExceptSelf(nums1));
        printArray(productExceptSelf(nums2));
    }
}
