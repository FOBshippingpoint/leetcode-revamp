package com.github.fobshippingpoint.s0621taskscheduler;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class Solution {

    public int leastInterval(char[] tasks, int n) {
        var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        var queueTaskCount = new ArrayDeque<Integer>();
        var queueCoolDownTime = new ArrayDeque<Integer>();

        var taskCounts = new int[26];
        for (var task : tasks) {
            taskCounts[task - 'A']++;
        }
        for (var taskCount : taskCounts) {
            if (taskCount > 0) {
                maxHeap.offer(taskCount);
            }
        }

        var time = 0;
        while (!maxHeap.isEmpty() || !queueTaskCount.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                var taskCount = maxHeap.remove() - 1;
                if (taskCount > 0) {
                    queueTaskCount.offer(taskCount);
                    queueCoolDownTime.offer(time + n);
                }
            }
            if (Objects.equals(queueCoolDownTime.peek(), time)) {
                queueCoolDownTime.poll();
                maxHeap.offer(queueTaskCount.poll());
            }
        }

        return time;
    }

}
