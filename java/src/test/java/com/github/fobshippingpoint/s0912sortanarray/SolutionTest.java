package com.github.fobshippingpoint.s0912sortanarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should sort distinct values in ascending order",
                        new int[]{5, 2, 3, 1}, new int[]{1, 2, 3, 5}),
                Arguments.of("Should sort duplicate values in ascending order",
                        new int[]{5, 1, 1, 2, 0, 0}, new int[]{0, 0, 1, 1, 2, 5})
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testSortArrayV1(String message, int[] nums, int[] expect) {
        assertArrayEquals(expect, new Solution().sortArray(nums), message);
    }

}
