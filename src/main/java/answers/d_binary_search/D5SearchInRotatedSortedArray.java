package answers.d_binary_search;

public class D5SearchInRotatedSortedArray {
    /**
     * Time Complexity: O(log n)
     * The time complexity of this solution is O(log n), where `n` is the number of elements in the array.
     * We use binary search, reducing the search space by half in each iteration.
     *
     * Space Complexity: O(1)
     * The space complexity is O(1) since we only use a few integer variables.
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Determine which half is sorted
            if (nums[left] <= nums[mid]) { // Left half is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Search left half
                } else {
                    left = mid + 1; // Search right half
                }
            } else { // Right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Search right half
                } else {
                    right = mid - 1; // Search left half
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
