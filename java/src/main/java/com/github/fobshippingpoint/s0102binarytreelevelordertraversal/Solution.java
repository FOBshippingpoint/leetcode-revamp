package com.github.fobshippingpoint.s0102binarytreelevelordertraversal;

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }
        var queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            var size = queue.size();
            var levels = new ArrayList<Integer>(2);
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                if (node != null) {
                    levels.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
            if (!levels.isEmpty()) {
                result.add(levels);
            }
        }
        return result;
    }

}
