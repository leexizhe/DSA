package answers.g_trees;

import static answers.g_trees.TreePrinter.printTree;

public class G12KthSmallestIntegerInBST {
    /**
     * Key Techniques:
     * ✅ In-order Traversal → Ensures elements are visited in sorted order
     * ✅ Stops Early Once K-th Element is Found → Prevents unnecessary recursion
     * ✅ O(n) Time Complexity in Worst Case, O(log n) for Balanced BST
     * Time Complexity: O(n)
     * Since we visit each node once, the worst-case complexity is O(n) for a skewed BST and O(log n) for a balanced BST.
     *
     * Space Complexity: O(h)
     * The recursive calls take space proportional to the tree height, leading to O(log n) space for a balanced BST and O(n) for a skewed tree.
     */
    private static int count = 0;

    private static int result = 0;

    public static int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private static void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k); // Process left subtree first

        count++;
        if (count == k) {
            result = node.val;
            return; // Stop recursion early once k-th element is found
        }

        inorder(node.right, k); // Process right subtree next
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println("Original Tree:");
        printTree(root);
        System.out.println();

        int k = 2;
        System.out.println("Kth Smallest Element: " + kthSmallest(root, k)); // Expected: 2
    }
}
