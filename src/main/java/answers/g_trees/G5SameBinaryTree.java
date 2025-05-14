package answers.g_trees;

import static answers.g_trees.TreePrinter.printTree;

public class G5SameBinaryTree {
    /**
     * Key Techniques:
     * ✅ Recursive traversal → Checks if both trees are identical.
     * ✅ O(n) Time Complexity → Traverses each node once in both trees.
     * ✅ Handles edge cases → Works for empty trees and unbalanced structures.
     *
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of nodes in the binary trees.
     * Each node is visited once to check equality.
     *
     * Space Complexity: O(h)
     * The space complexity is O(h), where h is the height of the tree.
     * In the worst case (a skewed tree), recursion depth reaches O(n).
     * In a balanced tree, recursion depth is O(log n).
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true; // Both trees are empty
        if (p == null || q == null) return false; // One tree is empty

        // Check values and recursively compare left & right subtrees
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        System.out.println("tree1:");
        printTree(tree1);
        System.out.println();

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        System.out.println("tree2:");
        printTree(tree2);
        System.out.println();

        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);
        tree3.right = new TreeNode(4); // Different value from tree1
        System.out.println("tree3:");
        printTree(tree3);
        System.out.println();

        System.out.println("Tree1 == Tree2: " + isSameTree(tree1, tree2)); // Output: true
        System.out.println("Tree1 == Tree3: " + isSameTree(tree1, tree3)); // Output: false
    }
}
