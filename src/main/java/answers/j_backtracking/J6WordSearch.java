package answers.j_backtracking;

public class J6WordSearch {
    /**
     * Key Techniques:
     * Backtracking with visited tracking → Ensures each cell is used only once in a single word path.
     * ✅ Generalizable Backtracking Template → Works for permutations, combinations, or path exploration problems.
     * ✅ Pruning via early return → Backtracks as soon as a mismatch is found, boosting efficiency.
     *
     * Time Complexity: O(m * n * 3^L)
     * m x n is the size of the board, L is the length of the word.
     * For each cell, we explore up to 3 directions (not 4 because we don’t go backward).
     *
     * Space Complexity: O(L)
     * The recursion stack goes as deep as the length of the word.
     */
    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean backtrack(char[][] board, String word, int idx, int row, int col) {
        // Out of bounds or character mismatch
        if (row < 0
                || row >= board.length
                || col < 0
                || col >= board[0].length
                || board[row][col] != word.charAt(idx)) {
            return false;
        }

        // All characters matched
        if (idx == word.length() - 1) return true;

        // Mark current cell as visited
        char temp = board[row][col];
        board[row][col] = '#'; // Use sentinel char to mark visited

        // Explore in 4 directions
        boolean found = backtrack(board, word, idx + 1, row + 1, col)
                || backtrack(board, word, idx + 1, row - 1, col)
                || backtrack(board, word, idx + 1, row, col + 1)
                || backtrack(board, word, idx + 1, row, col - 1);

        board[row][col] = temp; // Backtrack: undo visit marking

        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";
        System.out.println("Word exists: " + exist(board, word));
    }
}
