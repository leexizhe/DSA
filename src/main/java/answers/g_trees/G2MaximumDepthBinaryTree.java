package answers.g_trees;

public class G2MaximumDepthBinaryTree {
    /**
     * Key Techniques:
     * ✅ Recursion → Simplifies tree traversal logic.
     * ✅ O(n) Time Complexity → Efficiently processes all nodes.
     * ✅ Works on Skewed & Balanced Trees → Handles diverse tree structures effectively.
     *
     * Time Complexity: O(n)
     * We traverse each node exactly once, making the solution linear in time.
     *
     * Space Complexity: O(h)
     * The recursive call stack consumes space proportional to the tree’s height.
     * In the worst case (skewed tree), this is O(n), and in the best case (balanced tree), it is O(log n).
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        // Recursively find depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Max depth is the greater of left/right subtree depths + 1 (for root)
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Maximum Depth: " + maxDepth(root)); // Output: 3
    }
}
