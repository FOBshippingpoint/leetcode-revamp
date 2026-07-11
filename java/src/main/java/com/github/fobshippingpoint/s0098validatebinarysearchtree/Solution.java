package com.github.fobshippingpoint.s0098validatebinarysearchtree;

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

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValidBST(Long.MIN_VALUE, root, Long.MAX_VALUE);
    }

    public boolean isValidBST(long min, TreeNode node, long max) {
        if (node == null) {
            return true;
        }
        if (!(min < node.val && node.val < max)) {
            return false;
        }
        return isValidBST(min, node.left, node.val) && isValidBST(node.val, node.right, max);
    }

}
