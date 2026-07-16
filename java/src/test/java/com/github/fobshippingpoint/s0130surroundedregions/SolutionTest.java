package com.github.fobshippingpoint.s0130surroundedregions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should capture only regions not connected to an edge",
                        new char[][]{
                                {'X', 'X', 'X', 'X'},
                                {'X', 'O', 'O', 'X'},
                                {'X', 'X', 'O', 'X'},
                                {'X', 'O', 'X', 'X'}
                        },
                        new char[][]{
                                {'X', 'X', 'X', 'X'},
                                {'X', 'X', 'X', 'X'},
                                {'X', 'X', 'X', 'X'},
                                {'X', 'O', 'X', 'X'}
                        }),
                Arguments.of("Should leave a one-cell board unchanged",
                        new char[][]{{'X'}}, new char[][]{{'X'}})
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testSolveV1(String message, char[][] board, char[][] expect) {
        new Solution().solve(board);
        assertArrayEquals(expect, board, message);
    }
}
