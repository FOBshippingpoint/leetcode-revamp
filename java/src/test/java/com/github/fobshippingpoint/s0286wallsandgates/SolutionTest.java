package com.github.fobshippingpoint.s0286wallsandgates;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    private static final int INF = Integer.MAX_VALUE;

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should fill each room with the distance to its nearest gate",
                        new int[][]{
                                {INF, -1, 0, INF},
                                {INF, INF, INF, -1},
                                {INF, -1, INF, -1},
                                {0, -1, INF, INF}
                        },
                        new int[][]{
                                {3, -1, 0, 1},
                                {2, 2, 1, -1},
                                {1, -1, 2, -1},
                                {0, -1, 3, 4}
                        }),
                Arguments.of("Should route around a wall",
                        new int[][]{
                                {0, -1},
                                {INF, INF}
                        },
                        new int[][]{
                                {0, -1},
                                {1, 2}
                        }),
                Arguments.of("Should leave unreachable rooms unchanged",
                        new int[][]{
                                {INF, -1, 0},
                                {-1, INF, -1}
                        },
                        new int[][]{
                                {INF, -1, 0},
                                {-1, INF, -1}
                        })
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testWallsAndGatesV1(String message, int[][] rooms, int[][] expect) {
        new Solution().wallsAndGates(rooms);
        assertArrayEquals(expect, rooms, message);
    }
}
