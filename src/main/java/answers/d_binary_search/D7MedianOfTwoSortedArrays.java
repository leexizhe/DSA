package answers.d_binary_search;

public class D7MedianOfTwoSortedArrays {
    /**
     * Key Techniques:
     * ✅ Binary Search → Efficiently finds median without merging.
     * ✅ O(log(min(m, n))) Time Complexity → Optimal search on smaller array.
     * ✅ O(1) Space Complexity → No extra storage used.
     *
     * Time Complexity: O(log min(m, n))
     * We apply binary search on the smaller array to find partition.
     *
     * Space Complexity: O(1)
     * Uses only a few extra variables for index tracking.
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); // Ensure binary search runs on smaller array
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        int partitionX, partitionY;

        while (left <= right) {
            partitionX = left + (right - left) / 2;
            partitionY = (m + n + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            // Step 1: Check if partition is correct
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // Step 2: Compute median based on total size
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                right = partitionX - 1; // Move left
            } else {
                left = partitionX + 1; // Move right
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted properly");
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
