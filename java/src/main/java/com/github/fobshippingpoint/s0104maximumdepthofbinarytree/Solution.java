package com.github.fobshippingpoint.s0104maximumdepthofbinarytree;

import java.util.ArrayDeque;
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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        var depth = 0;
        var deque = new ArrayDeque<>(List.of(root));
        while (!deque.isEmpty()) {
            for (int i = 0; i < deque.size(); i++) {
                var node = deque.pollFirst();
                if (node.left != null) {
                    deque.offerLast(node.left);
                }
                if (node.right != null) {
                    deque.offerLast(node.right);
                }
            }
            depth += 1;
        }
        return depth;
    }

    public int maxDepthV3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        var nodeStack = new ArrayDeque<>(List.of(root));
        var depthStack = new ArrayDeque<>(List.of(1));

        int maxDepth = 1;
        while (!nodeStack.isEmpty()) {
            var node = nodeStack.pop();
            var depth = depthStack.pop();
            maxDepth = Math.max(maxDepth, depth);

            if (node.left != null) {
                nodeStack.push(node.left);
                depthStack.push(depth + 1);
            }
            if (node.right != null) {
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
            }
        }

        return maxDepth;
    }

}
