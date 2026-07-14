package com.github.fobshippingpoint.s0208implementtrieprefixtree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void testTrieV1() {
        var trie = new Solution.Trie();

        trie.insert("apple");
        assertTrue(trie.search("apple"), "Should find the inserted word apple");
        assertFalse(trie.search("app"), "Should not treat a prefix as an inserted word");
        assertTrue(trie.startsWith("app"), "Should find the prefix app");

        trie.insert("app");
        assertTrue(trie.search("app"), "Should find app after it is inserted");
    }

    @Test
    void testTrieV2() {
        var trie = new Solution.TrieV2();

        trie.insert("apple");
        assertTrue(trie.search("apple"), "Should find the inserted word apple");
        assertFalse(trie.search("app"), "Should not treat a prefix as an inserted word");
        assertTrue(trie.startsWith("app"), "Should find the prefix app");

        trie.insert("app");
        assertTrue(trie.search("app"), "Should find app after it is inserted");
    }

}
