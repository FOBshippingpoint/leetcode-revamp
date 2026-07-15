package com.github.fobshippingpoint.s0133clonegraph;

import java.util.*;

public class Solution {

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return dfs(node, new HashMap<>());
    }

    private Node dfs(Node node, Map<Node, Node> clonedMap) {
        var cloned = clonedMap.get(node);
        if (cloned != null) {
            return cloned;
        }
        cloned = new Node(node.val);
        clonedMap.put(node, cloned);
        for (var n : node.neighbors) {
            cloned.neighbors.add(dfs(n, clonedMap));
        }
        return cloned;
    }
   
}
