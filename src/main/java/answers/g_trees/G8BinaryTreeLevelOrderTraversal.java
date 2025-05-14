package answers.g_trees;

import static answers.g_trees.TreePrinter.printTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G8BinaryTreeLevelOrderTraversal {
    /**
     * Key Techniques:
     * ✅ Depth-First Search (DFS) → Uses recursion to process levels in order.
     * ✅ O(n) Time Complexity → Visits each node once.
     * ✅ Handles Edge Cases → Works for empty trees and unbalanced structures.
     *
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of nodes in the binary tree.
     * Each node is visited once.
     *
     * Space Complexity: O(h)
     * The space complexity is O(h), where h is the height of the tree (O(n) for a skewed tree, O(log n) for a balanced tree).
     */

    // DFS Approach with Global List
    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> levelOrderDFS(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private static void dfs(TreeNode node, int depth) {
        if (node == null) return;

        // Ensure list has a place for the current depth
        if (res.size() == depth) {
            res.add(new ArrayList<>());
        }

        // Add node value to corresponding level
        res.get(depth).add(node.val);

        // Recursive calls for left and right children
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    /**
     * Key Techniques:
     * ✅ Breadth-First Search (BFS) → Uses a queue to traverse level by level.
     * ✅ O(n) Time Complexity → Visits each node once.
     * ✅ Handles Edge Cases → Works for empty trees and unbalanced structures.
     *
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of nodes in the binary tree.
     * Each node is visited once.
     *
     * Space Complexity: O(n)
     * The space complexity is O(n), since we store nodes in a queue for traversal.
     */
    public static List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size(); // Track number of nodes at current level

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Original Tree:");
        printTree(root);
        System.out.println();

        System.out.println("Level Order Traversal: " + levelOrderDFS(root));
        // Output: [[3], [9, 20], [15, 7]]
        System.out.println("Level Order Traversal: " + levelOrderBFS(root));
        // Output: [[3], [9, 20], [15, 7]]
    }
}
