package answers.b_two_pointers;

public class B5TrappingRainWater {
    /**
     * Key Techniques:
     * ✅ Two-Pointer Approach → Efficiently tracks trapped water levels.
     * ✅ O(n) Time Complexity → Single-pass optimization.
     * ✅ O(1) Space Complexity → No extra storage required.
     *
     * Time Complexity: O(n)
     * Each index is processed at most once, ensuring linear efficiency.
     *
     * Space Complexity: O(1)
     * Uses only a few extra variables for tracking max heights.
     */
    public static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, trappedWater = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update left max
                } else {
                    trappedWater += leftMax - height[left]; // Calculate trapped water
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update right max
                } else {
                    trappedWater += rightMax - height[right]; // Calculate trapped water
                }
                right--;
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height2 = {4, 2, 0, 3, 2, 5};

        System.out.println(trap(height1)); // Output: 6
        System.out.println(trap(height2)); // Output: 9
    }
}
