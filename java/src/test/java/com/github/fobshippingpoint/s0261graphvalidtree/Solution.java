package com.github.fobshippingpoint.s0261graphvalidtree;

import java.util.*;

public class Solution {

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        var adjacency = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            adjacency.put(i, new ArrayList<>());
        }

        for (var edge : edges) {
            adjacency.get(edge[0]).add(edge[1]);
            adjacency.get(edge[1]).add(edge[0]);
        }

        var visited = new HashSet<Integer>();
        dfs(0, adjacency, visited);

        return visited.size() == n;
    }

    private void dfs(int node, Map<Integer, List<Integer>> adjacency, Set<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);
        for (var neighbor : adjacency.get(node)) {
            dfs(neighbor, adjacency, visited);
        }
    }

}
