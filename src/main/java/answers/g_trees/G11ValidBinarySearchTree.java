package answers.g_trees;

import static answers.g_trees.TreePrinter.printTree;

public class G11ValidBinarySearchTree {
    /**
     * Key Techniques:
     * ✅ Depth-First Search (DFS) → Traverses recursively while maintaining min/max range.
     * ✅ O(n) Time Complexity → Visits each node once for efficient validation.
     * ✅ Handles Skewed & Balanced Trees → Works across different structures seamlessly.
     *
     * Time Complexity: O(n)
     * Each node is checked once, ensuring linear time complexity.
     *
     * Space Complexity: O(h)
     * Recursion depth reaches O(n) for a skewed tree and O(log n) for a balanced tree.
     */
    public static boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean dfs(TreeNode node, long min, long max) {
        if (node == null) return true;

        // Validate current node value within min/max range
        if (node.val <= min || node.val >= max) return false;

        // Recursively validate left and right subtrees
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println("Original Tree:");
        printTree(root);
        System.out.println();

        boolean isBST = isValidBST(root);
        System.out.println("Is Valid BST? " + isBST);
    }
}
