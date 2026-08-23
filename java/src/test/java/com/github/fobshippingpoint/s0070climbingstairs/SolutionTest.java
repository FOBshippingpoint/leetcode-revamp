package com.github.fobshippingpoint.s0070climbingstairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should have two ways to climb two steps",
                        2, 2),
                Arguments.of("Should have three ways to climb three steps",
                        3, 3),
                Arguments.of("Should have one way to climb a single step",
                        1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testClimbStairsV1(String message, int n, int expect) {
        assertEquals(expect, new Solution().climbStairsV1(n), message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testClimbStairsV2(String message, int n, int expect) {
        assertEquals(expect, new Solution().climbStairsV2(n), message);
    }

}
