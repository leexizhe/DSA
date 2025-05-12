package answers.d_binary_search;

public class D4FindMinimumInRotatedSortedArray {
    /**
     * Key Techniques:
     * ✅ Binary Search → Efficiently finds the minimum element.
     * ✅ O(log n) Time Complexity → Continuously halves the search space.
     * ✅ O(1) Space Complexity → Performs in-place modifications.
     *
     * Time Complexity: O(log n)
     * We reduce the search space logarithmically by comparing midpoints.
     *
     * Space Complexity: O(1)
     * No extra storage is required beyond index tracking.
     */
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Step 1: If mid is greater than right, minimum must be in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Step 2: If mid is smaller than right, minimum must be in the left half (including mid)
                right = mid;
            }
        }

        return nums[left]; // The minimum element
    }

    public static void main(String[] args) {
        int[] array1 = {3, 4, 5, 1, 2};
        int[] array2 = {4, 5, 6, 7, 0, 1, 2};
        int[] array3 = {11, 13, 15, 17};

        System.out.println(findMin(array1)); // Output: 1
        System.out.println(findMin(array2)); // Output: 0
        System.out.println(findMin(array3)); // Output: 11
    }
}
