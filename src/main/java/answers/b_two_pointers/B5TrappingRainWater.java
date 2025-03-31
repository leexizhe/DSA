package answers.b_two_pointers;

public class B5TrappingRainWater {
    /**
     * Time Complexity: O(n)
     * - The array is traversed once using the two-pointer approach.
     * - Therefore, the overall time complexity is O(n).
     *
     * Space Complexity: O(1)
     * - No additional data structures (like arrays) are used, only variables for pointers and calculations.
     * - Thus, the space complexity is O(1).
     */
    public static int trap(int[] height) {
        // Edge case: If the height array is empty or null, no water can be trapped
        if (height == null || height.length == 0) return 0;

        // Initialize pointers, maximum heights, and result
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int result = 0;

        // Use a two-pointer approach
        while (left < right) {
            if (leftMax < rightMax) {
                // Move left pointer forward
                left++;
                // Update the left maximum height
                leftMax = Math.max(leftMax, height[left]);
                // Calculate the water trapped at the current position
                result += leftMax - height[left];
            } else {
                // Move right pointer backward
                right--;
                // Update the right maximum height
                rightMax = Math.max(rightMax, height[right]);
                // Calculate the water trapped at the current position
                result += rightMax - height[right];
            }
        }

        // Return the total water trapped
        return result;
    }

    public static void main(String[] args) {
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height2 = {4, 2, 0, 3, 2, 5};

        System.out.println(trap(height1)); // Output: 6
        System.out.println(trap(height2)); // Output: 9
    }
}
