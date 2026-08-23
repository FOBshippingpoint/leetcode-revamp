package com.github.fobshippingpoint.s0075sortcolors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should sort all three colors",
                        new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2}),
                Arguments.of("Should sort a three-element array",
                        new int[]{2, 0, 1}, new int[]{0, 1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testSortColorsV1(String message, int[] nums, int[] expect) {
        new Solution().sortColors(nums);
        assertArrayEquals(expect, nums, message);
    }

}
