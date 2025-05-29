package answers.g_trees;

import static answers.g_trees.TreePrinter.printTree;

public  class G13ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /**
     * Key Techniques:
     * ✅ Recursive DFS Approach → Constructs the tree without using a HashMap for inorder indexing
     * ✅ Utilizes `limit` for boundary control → Ensures correct left & right subtree construction
     * ✅ O(n) Time Complexity → Efficient traversal of all nodes
     * Time Complexity: O(n)
     * Each node is processed exactly once, leading to O(n) complexity.
     *
     * Space Complexity: O(n)
     * Due to recursive depth in worst-case scenarios (O(log n) for balanced trees, O(n) for skewed trees).
     */
    static int preIdx = 0;
    static int inIdx = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, Integer.MAX_VALUE);
    }

    private static TreeNode dfs(int[] preorder, int[] inorder, int limit) {
        if (preIdx >= preorder.length) return null; // Base case: all nodes processed
        if (inorder[inIdx] == limit) { // Boundary condition check
            inIdx++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx++]); // Create current root node
        root.left = dfs(preorder, inorder, root.val); // Construct left subtree
        root.right = dfs(preorder, inorder, limit); // Construct right subtree
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);
        System.out.println("Constructed Binary Tree Root: " + root.val); // Expected Output: 3
        System.out.println("Original Tree:");
        printTree(root);
        System.out.println();
    }
}
