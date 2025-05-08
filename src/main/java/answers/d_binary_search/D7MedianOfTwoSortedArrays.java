package answers.d_binary_search;

public class D7MedianOfTwoSortedArrays {
    /**
     * Time Complexity: O(log(min(m, n)))
     * The time complexity of this solution is O(log(min(m, n))), where `m` and `n` are the lengths of the input arrays.
     * Since we apply binary search on the smaller array, the performance is optimized.
     *
     * Space Complexity: O(1)
     * The space complexity of this solution is O(1) as we only use a few integer variables.
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); // Ensure binary search is applied on the smaller array
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;

        while (low <= high) {
            int partitionX = low + (high - low) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Invalid input");
    }

    public static void main(String[] args) {
        int[] array1 = {1, 3};
        int[] array2 = {2};
        int[] array3 = {1, 2};
        int[] array4 = {3, 4};

        System.out.println(findMedianSortedArrays(array1, array2)); // Output: 2.0
        System.out.println(findMedianSortedArrays(array3, array4)); // Output: 2.5
    }
}
