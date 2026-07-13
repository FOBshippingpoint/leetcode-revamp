package com.github.fobshippingpoint.s0079wordsearch;

public class Solution {

    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (backtrack(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrack(char[][] board, String word, int row, int col, int i) {
        if (i == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 ||
                row >= board.length || col >= board[0].length ||
                word.charAt(i) != board[row][col]
        ) {
            return false;
        }

        char old = board[row][col];
        board[row][col] = 0; // mark as visited
        var exist = (
                backtrack(board, word, row + 1, col, i + 1) ||
                        backtrack(board, word, row - 1, col, i + 1) ||
                        backtrack(board, word, row, col + 1, i + 1) ||
                        backtrack(board, word, row, col - 1, i + 1)
        );
        board[row][col] = old; // restore the path for other independent routes
        return exist;
    }

}
