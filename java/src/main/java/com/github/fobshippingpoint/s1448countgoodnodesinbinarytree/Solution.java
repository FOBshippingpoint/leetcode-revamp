package com.github.fobshippingpoint.s1448countgoodnodesinbinarytree;

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

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        var result = 0;
        if (node.val >= max) {
            result = 1;
        }
        max = Math.max(max, node.val);
        result += dfs(node.left, max);
        result += dfs(node.right, max);
        return result;
    }

}
