package answers.d_binary_search;

public class D5SearchInRotatedSortedArray {
    /**
     * Key Techniques:
     * ✅ Binary Search → Efficiently finds target in a rotated array.
     * ✅ O(log n) Time Complexity → Continuously halves the search space.
     * ✅ O(1) Space Complexity → Performs in-place modifications.
     *
     * Time Complexity: O(log n)
     * We reduce the search space logarithmically by comparing midpoints.
     *
     * Space Complexity: O(1)
     * No extra storage is required beyond index tracking.
     */
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Step 1: Determine which half is sorted
            if (nums[left] <= nums[mid]) { // Left half is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Search in left sorted half
                } else {
                    left = mid + 1; // Search in right half
                }
            } else { // Right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Search in right sorted half
                } else {
                    right = mid - 1; // Search in left half
                }
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] array1 = {4, 5, 6, 7, 0, 1, 2};
        int[] array2 = {5, 1, 3};
        int[] array3 = {6, 7, 8, 1, 2, 3, 4, 5};

        System.out.println(search(array1, 0)); // Output: 4
        System.out.println(search(array2, 3)); // Output: 2
        System.out.println(search(array3, 6)); // Output: 0
    }
}
