package com.github.fobshippingpoint.s0297serializeanddeserializebinarytree;

import java.util.StringJoiner;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class Codec {

        private StringJoiner code;
        private static final String NULL = "null";
        private static final String DELIMINATOR = ",";
        private int deserializePointer;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            code = new StringJoiner(DELIMINATOR);
            serializeDfs(root);
            return code.toString();
        }

        private void serializeDfs(TreeNode node) {
            if (node == null) {
                code.add(NULL);
            } else {
                code.add(String.valueOf(node.val));
                serializeDfs(node.left);
                serializeDfs(node.right);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            var values = data.split(DELIMINATOR);
            deserializePointer = 0;
            return deserializeDfs(values);
        }

        public TreeNode deserializeDfs(String[] values) {
            if (values[deserializePointer].equals(NULL)) {
                deserializePointer++;
                return null;
            } else {
                var node = new TreeNode(Integer.parseInt(values[deserializePointer]));
                deserializePointer++;
                node.left = deserializeDfs(values);
                node.right = deserializeDfs(values);
                return node;
            }
        }

    }

}
