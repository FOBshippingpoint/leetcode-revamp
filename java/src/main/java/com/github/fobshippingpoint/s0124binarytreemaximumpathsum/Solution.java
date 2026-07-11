package com.github.fobshippingpoint.s0124binarytreemaximumpathsum;

public class Solution {

    public static class TreeNode {
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

    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        var leftMax = Math.max(dfs(node.left), 0);
        var rightMax = Math.max(dfs(node.right), 0);
        maxSum = Math.max(maxSum, node.val + leftMax + rightMax);
        return node.val + Math.max(leftMax, rightMax);
    }

}
