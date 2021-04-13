package day10.s783;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 */
class Solution {
    int pre = -1;
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (null != root.left)
            minDiffInBST(root.left);
        if (pre != -1)
            min = Math.min(min, root.val - pre);
        pre = root.val;
        if (null != root.right)
            minDiffInBST(root.right);
        return min;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        Solution s = new Solution();
        System.out.println(s.minDiffInBST(node));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
