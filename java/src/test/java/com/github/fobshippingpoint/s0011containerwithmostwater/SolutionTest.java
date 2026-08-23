package com.github.fobshippingpoint.s0011containerwithmostwater;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should find the maximum area in the standard example",
                        new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.of("Should handle the smallest valid input",
                        new int[]{1, 1}, 1),
                Arguments.of("Should prefer width when the heights are flat",
                        new int[]{4, 4, 4, 4}, 12)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testMaxAreaV1(String message, int[] height, int expect) {
        assertEquals(expect, new Solution().maxArea(height), message);
    }

}
