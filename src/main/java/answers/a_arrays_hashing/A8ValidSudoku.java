package answers.a_arrays_hashing;

import java.util.HashSet;

public class A8ValidSudoku {
    /**
     * Key Techniques:
     * ✅ HashSet → Tracks seen numbers for efficient validation.
     * ✅ O(1) Time Complexity → Fixed 9x9 board ensures constant processing.
     * ✅ O(1) Space Complexity → Uses a limited number of hash sets.
     *
     * Time Complexity: O(1)
     * Since the board is fixed at 9x9, operations remain constant.
     *
     * Space Complexity: O(1)
     * Uses a few HashSets for tracking digits efficiently.
     */
    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue; // Skip empty cells

                // Track numbers for row, column, and box
                if (!seen.add(num + " in row " + i)
                        || !seen.add(num + " in col " + j)
                        || !seen.add(num + " in box " + (i / 3) + "-" + (j / 3))) {
                    return false; // Duplicate found
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test case
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board)); // Output: true
    }
}
