package com.github.fobshippingpoint.s0239slidingwindowmaximum;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int[] maxSlidingWindowV1(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>(nums.length, Comparator.reverseOrder());
        var result = new int[nums.length - k + 1];

        for (var i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (i >= k - 1) {
                result[i - k + 1] = pq.peek();
                pq.remove(nums[i - k + 1]); // Leaving the window
            }
        }

        return result;
    }

    public int[] maxSlidingWindowV2(int[] nums, int k) {
        var deque = new ArrayDeque<Integer>(k);
        var result = new int[nums.length - k + 1];

        for (var i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (deque.peek() < i - k + 1) {
                deque.poll();
            }
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }

}
