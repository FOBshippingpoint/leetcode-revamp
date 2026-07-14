package com.github.fobshippingpoint.s0208implementtrieprefixtree;

import java.util.HashMap;
import java.util.Map;

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

        public boolean search(String word) {
            var node = root;
            for (var ch : word.toCharArray()) {
                node = node.children.get(ch);
                if (node == null) {
                    return false;
                }
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            var node = root;
            for (var ch : prefix.toCharArray()) {
                node = node.children.get(ch);
                if (node == null) {
                    return false;
                }
            }
            return true;
        }

    }

    public static class TrieV2 {

        static class TrieNode {
            final TrieNode[] children = new TrieNode[26];
            boolean isEnd;
        }

        private final TrieNode root = new TrieNode();

        public void insert(String word) {
            var node = root;
            for (var i = 0; i < word.length(); i++) {
                var index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            var node = find(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return find(prefix) != null;
        }

        private TrieNode find(String text) {
            var node = root;
            for (var i = 0; i < text.length(); i++) {
                node = node.children[text.charAt(i) - 'a'];
                if (node == null) {
                    return null;
                }
            }
            return node;
        }
    }
}
