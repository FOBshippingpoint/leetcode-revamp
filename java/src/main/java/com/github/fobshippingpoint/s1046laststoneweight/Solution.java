package com.github.fobshippingpoint.s1046laststoneweight;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int lastStoneWeight(int[] stones) {
        var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (var weight : stones) {
            pq.add(weight);
        }

        while (pq.size() != 1) {
            var x = pq.remove();
            var y = pq.remove();
            pq.add(x - y);
        }
        return pq.remove();
    }

}
