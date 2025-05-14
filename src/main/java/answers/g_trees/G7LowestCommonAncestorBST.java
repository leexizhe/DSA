package answers.g_trees;

import static answers.g_trees.TreePrinter.printTree;

public class G7LowestCommonAncestorBST {
    /**
     * Key Techniques:
     * ✅ Binary Search Tree (BST) Properties → Leverages sorted structure for efficient traversal.
     * ✅ O(log n) Time Complexity → Uses BST properties to find LCA efficiently.
     * ✅ Handles Edge Cases → Works for skewed and balanced trees.
     *
     * Time Complexity: O(log n)
     * The time complexity of this solution is O(log n) in a balanced BST, as we eliminate half the search space in each step.
     * In the worst case (skewed tree), complexity is O(n).
     *
     * Space Complexity: O(1)
     * This approach uses constant space, as it doesn’t require additional data structures.
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left; // Both nodes are in the left subtree
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right; // Both nodes are in the right subtree
            } else {
                return root; // Found the split point where p and q are on different sides
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        System.out.println("Original Tree:");
        printTree(root);
        System.out.println();

        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.right; // Node with value 8

        System.out.println("Lowest Common Ancestor: " + lowestCommonAncestor(root, p, q).val); // Output: 6
    }
}
