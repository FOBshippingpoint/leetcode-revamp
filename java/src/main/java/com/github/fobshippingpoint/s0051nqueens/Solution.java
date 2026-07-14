package com.github.fobshippingpoint.s0051nqueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<String>> solveNQueens(int n) {
        var result = new ArrayList<List<String>>();
        for (var queens : backtrack(n, n)) {
            var board = new char[n][n];
            for (var row : board) {
                Arrays.fill(row, '.');
            }
            for (var queen : queens) {
                board[queen.x][queen.y] = 'Q';
            }

            var rows = new ArrayList<String>();
            for (var row : board) {
                rows.add(new String(row));
            }
            result.add(rows);
        }
        return result;
    }

    record Queen(int x, int y) {
    }

    private List<List<Queen>> backtrack(int n, int k) {
        if (k == 0) {
            return List.of(List.of());
        }

        var queensList = new ArrayList<List<Queen>>();
        for (var queens : backtrack(n, k - 1)) {
            for (int y = 0; y < n; y++) {
                var queen = new Queen(k - 1, y);
                if (queens.stream().allMatch(other -> isSafe(queen, other))) {
                    var list = new ArrayList<>(queens);
                    list.add(queen);
                    queensList.add(list);
                }
            }
        }
        return queensList;
    }

    private boolean isSafe(Queen a, Queen b) {
        return a.x != b.x &&
                a.y != b.y &&
                Math.abs(a.x - b.x) != Math.abs(a.y - b.y);
    }

    public List<List<String>> solveNQueensV2(int n) {
        var result = new ArrayList<List<String>>();
        var board = new char[n][n];
        for (var row : board) {
            Arrays.fill(row, '.');
        }

        backtrackV2(0, board, new boolean[n],
                new boolean[2 * n - 1], new boolean[2 * n - 1], result);
        return result;
    }

    private void backtrackV2(int row, char[][] board, boolean[] columns,
                             boolean[] descendingDiagonals, boolean[] ascendingDiagonals,
                             List<List<String>> result) {
        // Done
        if (row == board.length) {
            var solution = new ArrayList<String>();
            for (var boardRow : board) {
                solution.add(new String(boardRow));
            }
            result.add(solution);
            return;
        }

        // Each call is on the different row, so we only need to iterate columns
        for (var col = 0; col < board.length; col++) {
            var descending = row - col + board.length - 1;
            var ascending = row + col;
            /*
                          (0,2)
                     (1,1)
                (2,0)
                Ascending   row + col = constant

                (0,1)
                     (1,2)
                          (2,3)
                Descending  row - col = constant
             */
            if (columns[col] || descendingDiagonals[descending] || ascendingDiagonals[ascending]) {
                continue; // conflicts
            }

            board[row][col] = 'Q';
            columns[col] = true;
            descendingDiagonals[descending] = true;
            ascendingDiagonals[ascending] = true;

            backtrackV2(row + 1, board, columns,
                    descendingDiagonals, ascendingDiagonals, result);

            board[row][col] = '.';
            columns[col] = false;
            descendingDiagonals[descending] = false;
            ascendingDiagonals[ascending] = false;
        }
    }

}
