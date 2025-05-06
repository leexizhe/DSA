package answers.d_binary_search;

public class D4FindMinimumInRotatedSortedArray {
    /**
     * Time Complexity: O(log n)
     * The time complexity of this solution is O(log n) since we use binary search to efficiently find the minimum element.
     * Instead of scanning the entire array, we repeatedly divide the search space by half, leading to logarithmic time complexity.
     *
     * Space Complexity: O(1)
     * The space complexity of this solution is O(1) because we perform the search in-place without requiring additional data structures.
     */
    private static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;

            // If middle element is greater than the rightmost element, search right half
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                // Otherwise, search the left half (including middle)
                right = middle;
            }
        }

        // At the end of the loop, left points to the minimum element
        return nums[left];
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