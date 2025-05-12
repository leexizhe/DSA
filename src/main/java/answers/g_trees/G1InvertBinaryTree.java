package answers.g_trees;

import static answers.g_trees.TreePrinter.printTree;

public class G1InvertBinaryTree {
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
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap left and right subtrees
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("Original Tree:");
        printTree(root);
        System.out.println();

        System.out.println("Inverted Tree:");
        printTree(invertTree(root));
    }
}
