package com.github.fobshippingpoint.s0212wordsearchii;

import java.util.*;

public class Solution {

    public static class Trie {

        private final TrieNode root;

        static class TrieNode {
            final Map<Character, TrieNode> children = new HashMap<>(26);
            boolean isEnd;
        }

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            var node = root;
            for (var ch : word.toCharArray()) {
                node = node.children.computeIfAbsent(ch, ignored -> new TrieNode());
            }
            node.isEnd = true;
        }

    }

    public List<String> findWords(char[][] board, String[] words) {
        var trie = new Trie();
        for (var word : words) {
            trie.insert(word);
        }

        var result = new HashSet<String>();
        var visited = new HashSet<Cell>();
        for (var y = 0; y < board.length; y++) {
            for (var x = 0; x < board[0].length; x++) {
                backtrack(x, y, trie.root, "", visited, board, result);
            }
        }
        return new ArrayList<>(result);
    }

    record Cell(int x, int y) {
    }

    private void backtrack(int x, int y, Trie.TrieNode node, String word, Set<Cell> visited, char[][] board, Set<String> result) {
        var cell = new Cell(x, y);
        if (x < 0 || x >= board[0].length ||
                y < 0 || y >= board.length ||
                visited.contains(cell) ||
                node.children.get(board[y][x]) == null
        ) {
            return;
        }

        visited.add(cell);
        node = node.children.get(board[y][x]);
        word += board[y][x];
        if (node.isEnd) {
            result.add(word);
        }

        backtrack(x + 1, y, node, word, visited, board, result);
        backtrack(x - 1, y, node, word, visited, board, result);
        backtrack(x, y + 1, node, word, visited, board, result);
        backtrack(x, y - 1, node, word, visited, board, result);
        visited.remove(cell);
    }

}
