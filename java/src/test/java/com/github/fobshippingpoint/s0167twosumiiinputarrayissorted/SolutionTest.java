package com.github.fobshippingpoint.s0167twosumiiinputarrayissorted;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return [1,2] since sum of 2 and 7 is 9",
                        new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}),
                Arguments.of("Should return [1,3] since sum of 2 and 4 is 6",
                        new int[]{2, 3, 4}, 6, new int[]{1, 3}),
                Arguments.of("Should return [1,2] since sum of -1 and 0 is -1",
                        new int[]{-1, 0}, -1, new int[]{1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testTwoSumV1(String message, int[] numbers, int target, int[] expect) {
        var result = solution.twoSumV1(numbers, target);
        assertArrayEquals(expect, result, message);
    }

}
