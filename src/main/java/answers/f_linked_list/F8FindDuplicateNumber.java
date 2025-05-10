package answers.f_linked_list;

public class F8FindDuplicateNumber {
    /**
     * Time Complexity: O(n log n)
     * The time complexity of this solution is O(n log n) because we perform a binary search over the range [1, n-1],
     * and in each iteration, we traverse the array to count elements, making the overall complexity n log n.
     *
     * Space Complexity: O(1)
     * The space complexity is O(1) since we only use a few integer variables and do not allocate additional data structures.
     */
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int low = 1;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            // Count elements less than or equal to mid
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            // If count is greater than mid, duplicate is in lower half; else, it's in upper half
            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low; // The duplicate number
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3, 4, 2, 2};
        int[] array2 = {3, 1, 3, 4, 2};
        int[] array3 = {2, 2, 2, 2, 2};

        System.out.println(findDuplicate(array1)); // Output: 2
        System.out.println(findDuplicate(array2)); // Output: 3
        System.out.println(findDuplicate(array3)); // Output: 2
    }
}
