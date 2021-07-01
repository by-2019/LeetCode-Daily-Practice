package day38.jz37;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) {
            return "null";
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            sb.append(",");
            if (null != node.left) {
                queue.add(node.left);
                sb.append(node.left.val);
            } else {
                sb.append("null");
            }

            sb.append(",");
            if (null != node.right) {
                queue.add(node.right);
                sb.append(node.right.val);
            } else {
                sb.append("null");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (null == data || "null".equals(data)) {
            return null;
        }
        LinkedList<String> datas = new LinkedList<>(Arrays.asList(data.split(",")));
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(datas.removeFirst()));
        queue.add(root);
        while (!queue.isEmpty() && !datas.isEmpty()) {
            TreeNode node = queue.poll();
            String left = datas.removeFirst();
            if (!"null".equals(left)) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.add(node.left);
            }
            if (!datas.isEmpty()) {
                String right = datas.removeFirst();
                if (!"null".equals(right)) {
                    node.right = new TreeNode(Integer.parseInt(right));
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Codec c = new Codec();
        TreeNode des = c.deserialize("1,2,3,null,null,4,5");
        System.out.println(c.serialize(des));
    }
}
