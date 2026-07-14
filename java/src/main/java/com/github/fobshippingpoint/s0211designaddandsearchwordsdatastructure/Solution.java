package com.github.fobshippingpoint.s0211designaddandsearchwordsdatastructure;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static class WordDictionary {

        private final TrieNode root;

        static class TrieNode {
            final Map<Character, TrieNode> children = new HashMap<>(26);
            boolean isEnd;
        }

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            var node = root;
            for (var ch : word.toCharArray()) {
                node = node.children.computeIfAbsent(ch, ignored -> new TrieNode());
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            return backtrack(word.toCharArray(), 0, root);
        }

        private boolean backtrack(char[] word, int i, TrieNode node) {
            for (int j = i; j < word.length; j++) {
                var ch = word[j];
                if (ch == '.') {
                    for (var child : node.children.values()) {
                        if (backtrack(word, j + 1, child)) {
                            return true;
                        }
                    }
                    return false;
                }

                node = node.children.get(ch);
                if (node == null) {
                    return false;
                }
            }
            return node.isEnd;
        }

    }

}
