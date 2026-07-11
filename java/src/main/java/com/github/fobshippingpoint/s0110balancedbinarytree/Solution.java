package com.github.fobshippingpoint.s0110balancedbinarytree;

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

    public boolean isBalancedV1(TreeNode root) {
        return dfsV1(root)[0] == 1;
    }

    /**
     * @return two elements array, {isBalanced: int (true = 1; false = 0), depth: int}
     */
    public int[] dfsV1(TreeNode node) {
        if (node == null) {
            return new int[]{1, 0};
        }
        var left = dfsV1(node.left);
        var right = dfsV1(node.right);
        var isBalanced = (left[0] == 1 && right[0] == 1) && Math.abs(left[1] - right[1]) <= 1;
        return new int[]{isBalanced ? 1 : 0, 1 + Math.max(left[1], right[1])};
    }

    public boolean isBalancedV2(TreeNode root) {
        return getHeightV2(root) != -1;
    }

    /**
     * @return height of the tree, return -1 if the tree is not balanced.
     */
    public int getHeightV2(TreeNode node) {
        if (node == null) {
            return 0;
        }

        var left = getHeightV2(node.left);
        if (left == -1) return -1;

        var right = getHeightV2(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }

}
