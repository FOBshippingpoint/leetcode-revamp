package com.github.fobshippingpoint.s0684redundantconnection;

public class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        var parents = new int[edges.length + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (var edge: edges) {
            if (!union(edge[0], edge[1], parents)) {
                return edge;
            }
        }
        return new int[]{};
    }

    private int find(int node, int[] parents) {
        if (parents[node] != node) {
            parents[node] = find(parents[node], parents);
        }
        return parents[node];
    }

    private boolean union(int node1, int node2, int[] parents) {
        var p1 = find(node1, parents);
        var p2 = find(node2, parents);
        if (p1 == p2) {
            return false;
        }
        parents[p1] = p2;
        return true;
    }

}
