package com.github.fobshippingpoint.s0146lrucache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testLRUCacheV1() {
        var cache = new Solution.LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1), "Should return 1 for get(1)");

        cache.put(3, 3);
        assertEquals(-1, cache.get(2), "Should return -1 after key 2 is evicted");

        cache.put(4, 4);
        assertEquals(-1, cache.get(1), "Should return -1 after key 1 is evicted");
        assertEquals(3, cache.get(3), "Should return 3 for get(3)");
        assertEquals(4, cache.get(4), "Should return 4 for get(4)");
    }

}
