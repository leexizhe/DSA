package answers.g_trees;

import static answers.g_trees.TreePrinter.printTree;

import java.util.LinkedList;
import java.util.Queue;

public class G15SerializeAndDeserializeBinaryTree {
    // Serialize a Binary Tree to a String
    public static String serialize(TreeNode root) {
        if (root == null) return "null";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
                continue;
            }

            sb.append(node.val).append(",");
            queue.add(node.left);
            queue.add(node.right);
        }

        return sb.toString();
    }

    // Deserialize a String back to a Binary Tree
    public static TreeNode deserialize(String data) {
        if (data.equals("null")) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (!nodes[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(node.left);
            }
            i++;

            if (!nodes[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(node.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println("Original Tree:");
        printTree(root);
        System.out.println();

        String serialized = serialize(root);
        System.out.println("Serialized Tree: " + serialized);

        TreeNode deserializedRoot = deserialize(serialized);
        System.out.println("Deserialized Tree Root Value: " + deserializedRoot.val); // Expected: 1
        printTree(deserializedRoot);
    }
}
