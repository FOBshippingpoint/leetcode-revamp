package com.github.fobshippingpoint.s0684redundantconnection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should find the edge that closes a three-node cycle",
                        new int[][]{{1, 2}, {1, 3}, {2, 3}}, new int[]{2, 3}),
                Arguments.of("Should return the last removable edge",
                        new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}},
                        new int[]{1, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testFindRedundantConnectionV1(String message, int[][] edges, int[] expect) {
        assertArrayEquals(expect, new Solution().findRedundantConnection(edges), message);
    }
}
