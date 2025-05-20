package answers.g_trees;

import static answers.g_trees.TreePrinter.printTree;

public class G10CountGoodNodes {
    /**
     * Key Techniques:
     * ✅ Depth-First Search (DFS) → Ensures efficient traversal while tracking the max value seen so far.
     * ✅ O(n) Time Complexity → Visits each node once, ensuring optimal performance.
     * ✅ Works across Skewed & Balanced Trees → Handles all structures seamlessly.
     *
     * Time Complexity: O(n)
     * Every node is visited once, leading to linear time complexity.
     *
     * Space Complexity: O(h)
     * Recursion depth reaches O(n) for a skewed tree and O(log n) for a balanced tree.
     */
    public static int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private static int dfs(TreeNode node, int maxSoFar) {
        if (node == null) return 0;

        // Check if the current node is "good"
        int count = node.val >= maxSoFar ? 1 : 0;

        // Update max value seen so far in the path
        maxSoFar = Math.max(maxSoFar, node.val);

        // Recursively check left and right subtrees
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println("Original Tree:");
        printTree(root);
        System.out.println();

        int goodNodeCount = goodNodes(root);
        System.out.println("Count of Good Nodes: " + goodNodeCount);
    }
}
