package com.github.fobshippingpoint.s0295findmedianfromdatastream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    
    @Test
    void testMedianFinderV1() {
        var medianFinder = new Solution.MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertEquals(1.5, medianFinder.findMedian(),
                "Should return 1.5 after adding 1 and 2");

        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian(),
                "Should return 2.0 after adding 1, 2, and 3");
    }

}
