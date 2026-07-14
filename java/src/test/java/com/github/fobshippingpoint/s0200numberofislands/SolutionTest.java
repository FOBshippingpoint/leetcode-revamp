package com.github.fobshippingpoint.s0200numberofislands;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should count one connected island",
                        new char[][]{
                                {'1', '1', '1', '1', '0'},
                                {'1', '1', '0', '1', '0'},
                                {'1', '1', '0', '0', '0'},
                                {'0', '0', '0', '0', '0'}
                        }, 1),
                Arguments.of("Should count three separate islands",
                        new char[][]{
                                {'1', '1', '0', '0', '0'},
                                {'1', '1', '0', '0', '0'},
                                {'0', '0', '1', '0', '0'},
                                {'0', '0', '0', '1', '1'}
                        }, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testNumIslandsV1(String message, char[][] grid, int expect) {
        assertEquals(expect, new Solution().numIslands(grid), message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testNumIslandsV2(String message, char[][] grid, int expect) {
        assertEquals(expect, new Solution().numIslandsV2(grid), message);
    }

}
