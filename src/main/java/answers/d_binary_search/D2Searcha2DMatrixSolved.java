package answers.d_binary_search;

public class D2Searcha2DMatrixSolved {
    /**
     * Time Complexity: O(log(m * n))
     * The time complexity of this solution is O(log(m * n)), where m is the number of rows and n is the number of columns in the matrix.
     * Since the matrix is sorted, we can treat it as a 1D sorted array and apply binary search.
     *
     * Space Complexity: O(1)
     * The space complexity of this solution is O(1), since no extra storage is used, only a few variables.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int l = 0;
        int r = ROWS * COLS - 1;

        // Perform binary search treating the matrix as a linear sorted array
        while (l <= r) {
            int m = l + (r - l) / 2; // Avoid integer overflow

            // Convert 1D index back to 2D coordinates
            int row = m / COLS; // This helps map the 1D index to the correct row in the matrix.
            int col = m % COLS; // It gives us the remainder, which tells us the position within that row.

            if (target > matrix[row][col]) {
                l = m + 1; // Move right
            } else if (target < matrix[row][col]) {
                r = m - 1; // Move left
            } else {
                return true; // Found the target
            }
        }

        return false; // Target not found
    }
}
