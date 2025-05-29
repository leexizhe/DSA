package answers.g_trees;

import static answers.g_trees.TreePrinter.printTree;

public class G14BinaryTreeMaximumPathSum {
    /**
     * Key Techniques:
     * ✅ Recursive Depth Exploration → Uses DFS to find max contributions from left and right subtrees.
     * ✅ Handles Negative Paths → Ignores suboptimal paths using Math.max(..., 0).
     * ✅ O(n) Time Complexity → Traverses all nodes once.
     * ✅ Global Tracking Variable → Ensures we update the max path sum efficiently.
     *
     * Time Complexity: O(n)
     * Each node is visited once, making this approach linear in complexity.
     *
     * Space Complexity: O(h)
     * Recursive function calls use up stack memory, with worst case being O(n) for skewed trees, O(log n) for balanced trees.
     */
    static class Solution {
        int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return maxSum;
        }

        private int dfs(TreeNode node) {
            if (node == null) return 0;

            // Compute maximum sum contribution from left and right subtrees
            int leftMax = Math.max(dfs(node.left), 0);
            int rightMax = Math.max(dfs(node.right), 0);

            // Update global maxSum using current node and its best possible subtree paths
            maxSum = Math.max(maxSum, node.val + leftMax + rightMax);

            // Return max contribution when including the current node in a path
            return node.val + Math.max(leftMax, rightMax);
        }
    }

    public static void main(String[] args) {
        // Construct test tree
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Execute solution
        Solution solution = new Solution();
        int maxPathSum = solution.maxPathSum(root);
        System.out.println("Original Tree:");
        printTree(root);
        System.out.println();

        // Print the result
        System.out.println("Maximum Path Sum: " + maxPathSum);
    }
}
