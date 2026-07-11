package com.github.fobshippingpoint.s0230kthsmallestelementinabst;

import java.util.ArrayDeque;

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

    public int kthSmallestV1(TreeNode root, int k) {
        var n = 0;
        var stack = new ArrayDeque<TreeNode>();
        var curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            n++;
            if (n == k) {
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;
    }

    private int countV2;
    private int resultV2;

    public int kthSmallestV2(TreeNode root, int k) {
        countV2 = 0;
        dfs(root, k);
        return resultV2;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        // Go left
        dfs(node.left, k);

        countV2++;
        if (countV2 == k) {
            resultV2 = node.val;
            return;
        }

        // Go right
        if (countV2 < k) {
            dfs(node.right, k);
        }
    }

}
