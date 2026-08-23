package com.github.fobshippingpoint.s0743networkdelaytime;

import java.util.*;

public class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        var adj = new HashMap<Integer, List<int[]>>();
        for (var edge : times) {
            if (!adj.containsKey(edge[0])) {
                adj.put(edge[0], new ArrayList<>());
            }
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        var minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, k});

        var visited = new HashSet<Integer>();
        var maxDelay = 0;

        while (!minHeap.isEmpty()) {
            var top = minHeap.remove();
            var w1 = top[0];
            var n1 = top[1];

            if (visited.contains(n1)) {
                continue;
            }
            visited.add(n1);
            maxDelay = Math.max(w1, maxDelay);

            if (adj.containsKey(n1)) {
                for (var next : adj.get(n1)) {
                    var n2 = next[0];
                    var w2 = next[1];
                    minHeap.offer(new int[]{w1 + w2, n2});
                }
            }
        }

        return visited.size() == n ? maxDelay : -1;
    }

}
