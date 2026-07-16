package com.github.fobshippingpoint.s0323numberofconnectedcomponentsinanundirectedgraph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should count two disconnected components",
                        5, new int[][]{{0, 1}, {1, 2}, {3, 4}}, 2),
                Arguments.of("Should count one component when all nodes are connected",
                        5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testCountComponentsV1(String message, int n, int[][] edges, int expect) {
        assertEquals(expect, new Solution().countComponents(n, edges), message);
    }
}
