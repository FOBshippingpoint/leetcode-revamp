package com.github.fobshippingpoint.s0875kokoeatingbananas;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return 4 for piles = [3,6,7,11], h = 8",
                        new int[]{3, 6, 7, 11}, 8, 4),
                Arguments.of("Should return 30 for piles = [30,11,23,4,20], h = 5",
                        new int[]{30, 11, 23, 4, 20}, 5, 30),
                Arguments.of("Should return 23 for piles = [30,11,23,4,20], h = 6",
                        new int[]{30, 11, 23, 4, 20}, 6, 23)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testMinEatingSpeedV1(String message, int[] piles, int h, int expect) {
        var result = solution.minEatingSpeedV1(piles, h);
        assertEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testMinEatingSpeedV2(String message, int[] piles, int h, int expect) {
        var result = solution.minEatingSpeedV2(piles, h);
        assertEquals(expect, result, message);
    }

}