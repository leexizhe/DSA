package answers.b_two_pointers;

public class B4ContainerWithMostWater {
    /**
     * Key Techniques:
     * ✅ Two-Pointer Approach → Expands and contracts dynamically for max area.
     * ✅ O(n) Time Complexity → Single-pass optimization.
     * ✅ O(1) Space Complexity → No extra storage required.
     *
     * Time Complexity: O(n)
     * Each index is processed at most once, ensuring linear efficiency.
     *
     * Space Complexity: O(1)
     * Uses only a few extra variables for tracking indices.
     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minHeight * (right - left));

            // Move the pointer at the shorter height to try increasing the area
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] array2 = {1, 1};
        int[] array3 = {4, 3, 2, 1, 4};
        int[] array4 = {1, 2, 1};

        System.out.println(maxArea(array1)); // Output: 49
        System.out.println(maxArea(array2)); // Output: 1
        System.out.println(maxArea(array3)); // Output: 16
        System.out.println(maxArea(array4)); // Output: 2
    }
}
