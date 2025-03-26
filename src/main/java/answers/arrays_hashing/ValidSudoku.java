package answers.arrays_hashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    /**
     * Time Complexity: O(1)
     * - The board has a fixed size of 9x9 (81 cells), so the number of operations is constant.
     * - Each cell is processed once, and hash set operations (like `add`) are O(1).
     *
     * Space Complexity: O(1)
     * - The `HashSet` stores a constant number of entries (unique combinations of row, column, and sub-box constraints).
     * - Since the board size is fixed, space usage does not grow.
     */
    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        // Traverse the board
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];

                // Skip empty cells
                if (number != '.') {
                    // Add constraints to the set
                    if (!seen.add(number + " in row " + i)
                            || !seen.add(number + " in column " + j)
                            || !seen.add(number + " in block " + (i / 3) + "-" + (j / 3))) {
                        return false; // If any constraint is violated, return false
                    }
                }
            }
        }

        // If no violations, the board is valid
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
