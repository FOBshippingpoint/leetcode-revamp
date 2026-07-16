package com.github.fobshippingpoint.s0210coursescheduleii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var adjacency = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        // How many courses you need to complete before the course i?
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            var course = pre[0];
            var prerequisite = pre[1];
            adjacency.get(prerequisite).add(course);
            inDegree[course]++;
        }

        // The courses we can take first
        var queue = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        var completed = 0;
        var order = new int[numCourses];
        while (!queue.isEmpty()) {
            var course = queue.poll();
            order[completed] = course;
            completed++;

            for (int neighbor : adjacency.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return completed == numCourses ? order : new int[]{};
    }
}
