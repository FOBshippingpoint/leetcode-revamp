package com.github.fobshippingpoint.s0572subtreeofanothertree;

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

    public boolean isSubtreeV1(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot != null) return false;
        if (subRoot == null) return true;
        return isSameTreeV1(root, subRoot) || isSubtreeV1(root.left, subRoot) || isSubtreeV1(root.right, subRoot);
    }

    private boolean isSameTreeV1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTreeV1(p.left, q.left) && isSameTreeV1(p.right, q.right);
    }

    public boolean isSubtreeV2(TreeNode root, TreeNode subRoot) {
        var rootStr = serialize(root, new StringBuilder());
        var subRootStr = serialize(subRoot, new StringBuilder());

        return rootStr.indexOf(subRootStr.toString()) != -1;
    }

    public StringBuilder serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return sb.append("#");
        }

        sb.append(",").append(node.val);
        serialize(node.left, sb);
        serialize(node.right, sb);
        return sb;
    }

}
