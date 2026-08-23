package com.github.fobshippingpoint.s0743networkdelaytime;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return the longest time needed to reach every node in a connected graph",
                        new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2, 2),
                Arguments.of("Should return the delay for a simple two-node graph",
                        new int[][]{{1, 2, 1}}, 2, 1, 1),
                Arguments.of("Should return -1 when some nodes are unreachable",
                        new int[][]{{1, 2, 1}}, 2, 2, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testNetworkDelayTimeV1(String message, int[][] times, int n, int k, int expect) {
        assertEquals(expect, new Solution().networkDelayTime(times, n, k), message);
    }

}
