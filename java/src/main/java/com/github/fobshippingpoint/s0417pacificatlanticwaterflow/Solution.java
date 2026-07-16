package com.github.fobshippingpoint.s0417pacificatlanticwaterflow;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        var rows = heights.length;
        var cols = heights[0].length;
        var pacific = new boolean[rows][cols];
        var atlantic = new boolean[rows][cols];

        for (var r = 0; r < rows; r++) {
            dfs(r, 0, pacific, heights);
            dfs(r, cols - 1, atlantic, heights);
        }
        for (var c = 0; c < cols; c++) {
            dfs(0, c, pacific, heights);
            dfs(rows - 1, c, atlantic, heights);
        }

        var result = new ArrayList<List<Integer>>();
        for (var r = 0; r < rows; r++) {
            for (var c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int row, int col, boolean[][] visited, int[][] heights) {
        visited[row][col] = true;
        var directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (var direction : directions) {
            var r = row + direction[0];
            var c = col + direction[1];
            if (r >= 0 && r < heights.length
                    && c >= 0 && c < heights[0].length
                    && !visited[r][c]
                    && heights[r][c] >= heights[row][col]) {
                dfs(r, c, visited, heights);
            }
        }
    }

}
