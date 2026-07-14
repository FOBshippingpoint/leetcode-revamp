package com.github.fobshippingpoint.s0695maxareaofisland;

public class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        var rows = grid.length;
        var cols = grid[0].length;
        var maxArea = 0;

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (grid[y][x] == 1) {
                    var area = dfs(grid, x, y, rows, cols);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int x, int y, int rows, int cols) {
        if (x < 0 || x >= cols || y < 0 || y >= rows || grid[y][x] == 0) {
            return 0;
        }
        grid[y][x] = 0; // mark as visited

        return 1 +
                dfs(grid, x - 1, y, rows, cols) +
                dfs(grid, x + 1, y, rows, cols) +
                dfs(grid, x, y - 1, rows, cols) +
                dfs(grid, x, y + 1, rows, cols);
    }

}
