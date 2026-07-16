package com.github.fobshippingpoint.s0994rottingoranges;

import java.util.ArrayDeque;

public class Solution {

    public int orangesRotting(int[][] grid) {
        var rows = grid.length;
        var cols = grid[0].length;
        var freshOranges = 0;

        var queue = new ArrayDeque<int[]>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    freshOranges++;
                } else if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        var minutes = 0;
        while (!queue.isEmpty() && freshOranges > 0) {
            minutes++;
            var size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.remove();

                var row = current[0];
                var col = current[1];
                for (var dir : new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}) {
                    var r = row + dir[0];
                    var c = col + dir[1];
                    if (r >= 0 && r < rows &&
                            c >= 0 && c < cols &&
                            grid[r][c] == 1) {
                        grid[r][c] = 2; // rotten
                        queue.offer(new int[]{r, c});
                        freshOranges--;
                    }
                }
            }
        }

        return freshOranges == 0 ? minutes : -1;
    }

}
