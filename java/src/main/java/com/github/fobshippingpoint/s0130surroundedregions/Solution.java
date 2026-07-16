package com.github.fobshippingpoint.s0130surroundedregions;

public class Solution {

    public void solve(char[][] board) {

        var rows = board.length;
        var cols = board[0].length;


        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O' && isAtEdge(r, c, rows, cols)) {
                    dfs(r, c, rows, cols, board);
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private boolean isAtEdge(int r, int c, int rows, int cols) {
        return r == 0 || r == rows - 1 || c == 0 || c == cols - 1;
    }

    private void dfs(int r, int c, int rows, int cols, char[][] board) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        dfs(r + 1, c, rows, cols, board);
        dfs(r - 1, c, rows, cols, board);
        dfs(r, c + 1, rows, cols, board);
        dfs(r, c - 1, rows, cols, board);
    }

}
