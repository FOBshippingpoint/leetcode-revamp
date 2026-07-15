package com.github.fobshippingpoint.s0286wallsandgates;

import java.util.ArrayDeque;

public class Solution {

    public void wallsAndGates(int[][] rooms) {
        var rows = rooms.length;
        var cols = rooms[0].length;

        var queue = new ArrayDeque<int[]>();
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (rooms[y][x] == 0) {
                    queue.add(new int[]{y, x});
                }
            }
        }

        while (!queue.isEmpty()) {
            var gate = queue.poll();
            var y = gate[0];
            var x = gate[1];
            addRoom(rooms, queue, x, y - 1, rooms[y][x] + 1);
            addRoom(rooms, queue, x, y + 1, rooms[y][x] + 1);
            addRoom(rooms, queue, x - 1, y, rooms[y][x] + 1);
            addRoom(rooms, queue, x + 1, y, rooms[y][x] + 1);
        }
    }

    private void addRoom(int[][] rooms, ArrayDeque<int[]> gates, int x, int y, int distance) {
        if (x < 0 || x >= rooms[0].length || y < 0 || y >= rooms.length
                || rooms[y][x] != Integer.MAX_VALUE) {
            return;
        }
        rooms[y][x] = distance;
        gates.add(new int[]{y, x});
    }

}
