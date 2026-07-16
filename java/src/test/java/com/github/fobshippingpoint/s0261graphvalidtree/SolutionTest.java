package com.github.fobshippingpoint.s0261graphvalidtree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return true for a connected graph without a cycle",
                        5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}, true),
                Arguments.of("Should return false for a graph containing a cycle",
                        5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testValidTreeV1(String message, int n, int[][] edges, boolean expect) {
        assertEquals(expect, new Solution().validTree(n, edges), message);
    }
}
