package com.github.fobshippingpoint.s0973kclosestpointstoorigin;

import java.util.PriorityQueue;

public class Solution {

    public record CrateV1(int distance, int[] point) implements Comparable<CrateV1> {
        @Override
        public int compareTo(CrateV1 o) {
            return Integer.compare(distance, o.distance);
        }
    }

    public int[][] kClosestV1(int[][] points, int k) {
        var pq = new PriorityQueue<CrateV1>();
        for (var point : points) {
            pq.add(new CrateV1(point[0] * point[0] + point[1] * point[1], point));
        }
        var result = new int[k][];
        for (int i = 0; i < k; i++) {
            var crate = pq.remove();
            result[i] = crate.point();
        }
        return result;
    }

    public int[][] kClosestV2(int[][] points, int k) {
        var pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(distance(a), distance(b)));
        for (var point : points) {
            pq.add(point);
        }
        var result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = pq.remove();
        }
        return result;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

}
