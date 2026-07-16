package com.github.fobshippingpoint.s0323numberofconnectedcomponentsinanundirectedgraph;

public class Solution {

    public int countComponents(int n, int[][] edges) {
        var parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        var components = n;
        for (var edge : edges) {
            var root1 = findParent(edge[0], parent);
            var root2 = findParent(edge[1], parent);
            if (root1 != root2) {
                parent[root1] = root2;
                components--;
            }
        }

        return components;
    }

    private int findParent(int node, int[] parents) {
        if (parents[node] == node) {
            return node;
        }
        var parent = findParent(parents[node], parents);
        parents[node] = parent;
        return parent;
    }

}
