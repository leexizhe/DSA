package answers.g_trees;

import static answers.g_trees.TreePrinter.printTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G9BinaryTreeRightSideView {
    /**
     * Key Techniques:
     * ✅ Depth-First Search (DFS) → Ensures recursive traversal prioritizing right children.
     * ✅ Tracks Depth → Helps capture first node at each level efficiently.
     * ✅ O(n) Time Complexity → Visits each node once for optimized performance.
     * ✅ Handles all tree structures → Works across balanced and skewed trees seamlessly.
     *
     * Time Complexity: O(n)
     * We traverse the entire binary tree once, making it highly efficient.
     *
     * Space Complexity: O(h)
     * In the worst case (skewed tree), recursion depth reaches O(n).
     * In a balanced tree, recursion depth stays around O(log n).
     */
    static List<Integer> result = new ArrayList<>();

    public static List<Integer> rightSideViewDFS(TreeNode root) {

        dfs(root, 0);
        return result;
    }

    private static void dfs(TreeNode node, int depth) {
        if (node == null) return;

        // If visiting this depth for the first time, add the node value
        if (depth == result.size()) {
            result.add(node.val);
        }

        // Prioritize right subtree for rightmost view
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }

    /**
     * Key Techniques:
     * ✅ Level Order Traversal → Ensures each level is fully processed before moving to the next.
     * ✅ Uses Queue (BFS) → Guarantees a clear and structured approach.
     * ✅ O(n) Time Complexity → Efficient traversal visiting each node once.
     * ✅ Works for all tree structures → Handles both skewed and balanced trees seamlessly.
     *
     * Time Complexity: O(n)
     * We traverse all nodes in the binary tree once, ensuring efficient processing.
     *
     * Space Complexity: O(n)
     * In the worst case, we store all nodes in the queue, leading to O(n) space complexity.
     */
    public static List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode rightMostNode = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                rightMostNode = current; // Track last node in this level

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            if (rightMostNode != null) result.add(rightMostNode.val);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println("Original Tree:");
        printTree(root);
        System.out.println();

        List<Integer> rightSideViewDFS = rightSideViewDFS(root);
        System.out.println("Binary Tree Right Side View: " + rightSideViewDFS);
        List<Integer> rightSideViewBFS = rightSideViewBFS(root);
        System.out.println("Binary Tree Right Side View: " + rightSideViewBFS);
    }
}
