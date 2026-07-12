package com.github.fobshippingpoint.s0295findmedianfromdatastream;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class Solution {

    public static class MedianFinder {

        // left:  all numbers are smaller than the right.
        private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // right: all numbers are larger than the left.
        private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public void addNum(int num) {
            maxHeap.offer(num);
            // If the maximum number of left is larger than right, should move it to the right.
            if (Objects.compare(maxHeap.peek(), minHeap.peek(), Comparator.nullsFirst(Comparator.naturalOrder())) > 0) {
                minHeap.offer(maxHeap.poll());
            }

            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            } else if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.size() == maxHeap.size()) {
                return (minHeap.peek() + maxHeap.peek()) / 2d;
            } else if (minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            } else {
                return maxHeap.peek();
            }
        }

    }

}
