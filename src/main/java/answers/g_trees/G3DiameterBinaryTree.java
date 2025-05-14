package answers.g_trees;

import static answers.g_trees.TreePrinter.printTree;

public class G3DiameterBinaryTree {
    /**
     * Key Techniques:
     * ✅ Depth-first traversal → Computes max depth while tracking the longest path.
     * ✅ O(n) Time Complexity → Ensures efficiency by visiting each node once.
     * ✅ Handles Skewed & Balanced Trees → Works for all tree structures.
     *
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of nodes in the binary tree.
     * We traverse each node once to compute the depth and diameter.
     *
     * Space Complexity: O(h)
     * The space complexity is O(h), where h is the height of the tree.
     * This accounts for recursive function calls in the worst case (O(n) for a skewed tree, O(log n) for a balanced tree).
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameter = new int[1]; // Using an array to hold the mutable value
        computeDepth(root, maxDiameter);
        return maxDiameter[0];
    }

    private static int computeDepth(TreeNode node, int[] maxDiameter) {
        if (node == null) return 0;

        // Compute depth recursively for left and right subtrees
        int leftDepth = computeDepth(node.left, maxDiameter);
        int rightDepth = computeDepth(node.right, maxDiameter);

        // Update max diameter
        maxDiameter[0] = Math.max(maxDiameter[0], leftDepth + rightDepth);

        // Return depth (including current node)
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("Original Tree:");
        printTree(root);
        System.out.println();

        System.out.println("Diameter of Binary Tree: " + diameterOfBinaryTree(root)); // Output: 3
    }
}
