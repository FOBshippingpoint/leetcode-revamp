package com.github.fobshippingpoint.s0200numberofislands;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    record Point(int x, int y) {

        char at(char[][] grid) {
            return grid[y][x];
        }

        boolean isSafe(char[][] grid) {
            return 0 <= x && x < grid[0].length && 0 <= y && y < grid.length;
        }

        Point[] extend() {
            return new Point[]{
                    new Point(x - 1, y),
                    new Point(x + 1, y),
                    new Point(x, y - 1),
                    new Point(x, y + 1),
            };
        }

    }

    public int numIslands(char[][] grid) {
        var visited = new HashSet<Point>();
        var islands = 0;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '1' && !visited.contains(new Point(x, y))) {
                    bfs(x, y, visited, grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfs(int x, int y, Set<Point> visited, char[][] grid) {
        var queue = new ArrayDeque<Point>();
        var point = new Point(x, y);
        visited.add(point);
        queue.offer(point);

        while (!queue.isEmpty()) {
            for (var p : queue.poll().extend()) {
                if (p.isSafe(grid) && p.at(grid) == '1' && !visited.contains(p)) {
                    queue.offer(p);
                    visited.add(p);
                }
            }
        }
    }

    public int numIslandsV2(char[][] grid) {
        var islands = 0;
        var rows = grid.length;
        var cols = grid[0].length;

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (grid[y][x] == '1') {
                    dfsV2(grid, x, y, rows, cols);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfsV2(char[][] grid, int x, int y, int rows, int cols) {
        if (x < 0 || x >= cols || y < 0 || y >= rows || grid[y][x] == '0') {
            return;
        }
        grid[y][x] = '0'; // mark as visited

        dfsV2(grid, x - 1, y, rows, cols);
        dfsV2(grid, x + 1, y, rows, cols);
        dfsV2(grid, x, y - 1, rows, cols);
        dfsV2(grid, x, y + 1, rows, cols);
    }

}
