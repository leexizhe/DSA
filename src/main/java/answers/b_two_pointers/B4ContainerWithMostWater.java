package answers.b_two_pointers;

public class B4ContainerWithMostWater {
    /**
     * Time Complexity: O(n)
     * - The two-pointer approach ensures each element is visited at most once, resulting in a linear time complexity.
     *
     * Space Complexity: O(1)
     * - The space complexity is constant because only a few integer variables are used, and no additional data structures are created.
     */
    public static int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;

        // Use two pointers to iterate through the array
        while (left < right) {
            // Calculate the height and area of the container
            int maxHeight = Math.min(height[left], height[right]);
            area = Math.max(area, (right - left) * maxHeight);

            // Move the pointer with the smaller height
            while (left < right && maxHeight >= height[left]) {
                left++;
            }
            while (left < right && maxHeight >= height[right]) {
                right--;
            }
        }

        // Return the maximum area found
        return area;
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
