package Arrays_Hashing;

import static common.PrintArray.printArray;

public class ProductOfArrayExceptSelf {
    private static int[] productExceptSelf(int[] nums) {
        // time O(n)
        // space O(1)
        // use another array

        int left = 1;
        int right = 1;
        int length = nums.length;
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = left;
            left *= nums[i];
        }

        for (int i = length - 1; i >= 0; i--) {
            arr[i] *= right;
            right *= nums[i];
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {-1, 1, 0, -3, 3};
        printArray(productExceptSelf(nums1));
        printArray(productExceptSelf(nums1));
    }
}
