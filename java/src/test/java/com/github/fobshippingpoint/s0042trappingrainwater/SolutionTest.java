package com.github.fobshippingpoint.s0042trappingrainwater;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should trap 6 units of rain water for height [0,1,0,2,1,0,1,3,2,1,2,1]",
                        new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
                Arguments.of("Should trap 9 units of rain water for height [4,2,0,3,2,5]",
                        new int[]{4, 2, 0, 3, 2, 5}, 9),
                Arguments.of("Should trap 9 units of rain water for height [0,2,0,3,1,0,1,3,2,1]",
                        new int[]{0, 2, 0, 3, 1, 0, 1, 3, 2, 1}, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testTrapV1(String message, int[] height, int expect) {
        var result = solution.trapV1(height);
        assertEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testTrapV2(String message, int[] height, int expect) {
        var result = solution.trapV2(height);
        assertEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testTrapV3(String message, int[] height, int expect) {
        var result = solution.trapV3(height);
        assertEquals(expect, result, message);
    }

}
