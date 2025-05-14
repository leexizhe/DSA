package answers.g_trees;

import static answers.g_trees.TreePrinter.printTree;

public class G6SubtreeOfAnotherTree {
    /**
     * Key Techniques:
     * ✅ DFS + Same Tree Check → Uses depth-first search to locate subtree and validate structure.
     * ✅ O(m * n) Time Complexity → Checks every node in the main tree against the subtree.
     * ✅ Handles edge cases → Works for empty trees and structurally different trees.
     *
     * Time Complexity: O(m * n)
     * The worst-case time complexity is O(m * n), where m is the number of nodes in the main tree and n is the number of nodes in the subtree.
     * Each node in the main tree could be checked against the entire subtree structure.
     *
     * Space Complexity: O(h)
     * The space complexity is O(h), where h is the height of the main tree.
     * This accounts for recursive function calls in the worst case (O(m) for a skewed tree, O(log m) for a balanced tree).
     */
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false; // Base case

        // Check if current subtree matches or search left/right subtrees
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        System.out.println("Original Tree:");
        printTree(root);
        System.out.println();

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);
        System.out.println("Original SubTree:");
        printTree(subRoot);
        System.out.println();

        System.out.println("Is Subtree: " + isSubtree(root, subRoot)); // Output: true
    }
}
