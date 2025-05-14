package answers.g_trees;

import static answers.g_trees.TreePrinter.printTree;

public class G4BalancedBinaryTree {
    /**
     * Key Techniques:
     * ✅ Depth-First Search (DFS) → Efficiently determines tree height while checking balance.
     * ✅ O(n) Time Complexity → Traverses all nodes once for optimized performance.
     * ✅ Returns Height or -1 → Ensures early termination if imbalance is detected.
     * ✅ Works for all tree structures → Handles skewed and balanced trees seamlessly.
     *
     * Time Complexity: O(n)
     * We traverse the entire binary tree once, ensuring efficient detection of balance.
     *
     * Space Complexity: O(h)
     * Recursion depth reaches O(n) for a skewed tree and O(log n) for a balanced tree.
     */
    public static boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private static int dfsHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = dfsHeight(node.left);
        if (leftHeight == -1) return -1; // Early termination for imbalance

        int rightHeight = dfsHeight(node.right);
        if (rightHeight == -1) return -1; // Early termination for imbalance

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // Imbalanced tree detected

        return Math.max(leftHeight, rightHeight) + 1; // Return height if balanced
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Original Tree:");
        printTree(root);
        System.out.println();

        boolean balanced = isBalanced(root);
        System.out.println("Is Balanced Binary Tree? " + balanced);
    }
}
