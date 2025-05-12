package answers.g_trees;

import static answers.g_trees.TreePrinter.printTree;

public class G1InvertBinaryTree {
    /**
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of nodes in the binary tree.
     * We traverse each node once, swapping the left and right children.
     *
     * Space Complexity: O(h)
     * The space complexity is O(h), where h is the height of the tree.
     * This accounts for recursive function calls in the worst case (O(n) for a skewed tree, O(log n) for a balanced tree).
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

        root = invertTree(root);

        System.out.println("Inverted Tree:");
        printTree(root);
    }
}
