package com.github.fobshippingpoint.s0105constructbinarytreefrompreorderandinordertraversal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public TreeNode buildTreeV1(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        var root = new TreeNode(preorder[0]);
        int mid = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }
        root.left = buildTreeV1(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTreeV1(Arrays.copyOfRange(preorder, mid + 1, preorder.length), Arrays.copyOfRange(inorder, mid + 1, inorder.length));

        return root;
    }

    public TreeNode buildTreeV2(int[] preorder, int[] inorder) {
        var inorderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return recursiveBuildTreeV2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    public TreeNode recursiveBuildTreeV2(int[] preorder, int preFrom, int preTo, int[] inorder, int inFrom, int inTo, Map<Integer, Integer> inorderMap) {
        if (preFrom > preTo || inFrom > inTo) {
            return null;
        }
        var root = new TreeNode(preorder[preFrom]);
        var inIdx = inorderMap.get(preorder[preFrom]);
        var numsLeft = inIdx - inFrom;
        root.left = recursiveBuildTreeV2(preorder, preFrom + 1, preFrom + numsLeft, inorder, inFrom, inIdx - 1, inorderMap);
        root.right = recursiveBuildTreeV2(preorder, preFrom + numsLeft + 1, preTo, inorder, inIdx + 1, inTo, inorderMap);
        return root;
    }

}
