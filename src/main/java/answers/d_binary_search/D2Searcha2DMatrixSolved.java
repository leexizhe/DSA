package answers.d_binary_search;

public class D2Searcha2DMatrixSolved {
    /**
     * Key Techniques:
     * ✅ Binary Search → Treats the matrix as a sorted 1D array.
     * ✅ O(log(m*n)) Time Complexity → Efficiently searches using division.
     * ✅ O(1) Space Complexity → Performs in-place searches without extra memory.
     *
     * Time Complexity: O(log(m * n))
     * We apply binary search on an m × n matrix, treating it as a sorted array.
     *
     * Space Complexity: O(1)
     * Uses only a few extra variables for index tracking.
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = matrix[mid / cols][mid % cols];

            if (midElement == target) return true;
            else if (midElement < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println("Target Found: " + searchMatrix(matrix, target)); // Output: true
    }
}
