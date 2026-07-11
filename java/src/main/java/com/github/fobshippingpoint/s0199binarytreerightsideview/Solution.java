package com.github.fobshippingpoint.s0199binarytreerightsideview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> rightSideView(TreeNode root) {
        var result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        var queue = new ArrayDeque<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode rightMost = null;
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                if (node != null) {
                    rightMost = node;
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
            if (rightMost != null) {
                result.add(rightMost.val);
            }
        }

        return result;
    }

}
