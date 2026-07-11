package com.github.fobshippingpoint.s0703kthlargestelementinastream;

import java.util.PriorityQueue;

public class Solution {

    public static class KthLargest {

        private final PriorityQueue<Integer> pq;
        private final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for (var n : nums) {
                pq.add(n);
            }
            while (pq.size() > k) {
                pq.remove();
            }
        }

        public int add(int val) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }

            return pq.peek();
        }

    }

}
