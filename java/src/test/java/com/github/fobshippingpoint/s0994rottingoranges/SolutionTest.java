package com.github.fobshippingpoint.s0994rottingoranges;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should rot all fresh oranges in four minutes",
                        new int[][]{
                                {2, 1, 1},
                                {1, 1, 0},
                                {0, 1, 1}
                        }, 4),
                Arguments.of("Should return minus one when a fresh orange is unreachable",
                        new int[][]{
                                {2, 1, 1},
                                {0, 1, 1},
                                {1, 0, 1}
                        }, -1),
                Arguments.of("Should return zero when there are no fresh oranges",
                        new int[][]{{0, 2}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testOrangesRottingV1(String message, int[][] grid, int expect) {
        assertEquals(expect, new Solution().orangesRotting(grid), message);
    }
}
