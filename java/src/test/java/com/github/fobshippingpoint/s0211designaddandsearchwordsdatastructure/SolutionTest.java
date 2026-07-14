package com.github.fobshippingpoint.s0211designaddandsearchwordsdatastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void testWordDictionaryV1() {
        var dictionary = new Solution.WordDictionary();

        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");

        assertFalse(dictionary.search("pad"), "Should not find an absent exact word");
        assertTrue(dictionary.search("bad"), "Should find an inserted exact word");
        assertTrue(dictionary.search(".ad"), "Should match a wildcard at the start");
        assertTrue(dictionary.search("b.."), "Should match multiple wildcards");
    }

}
