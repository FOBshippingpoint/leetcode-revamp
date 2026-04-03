package com.github.fobshippingpoint.s0347topkfrequentelements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Example 1", new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2}),
                Arguments.of("Example 2", new int[]{1}, 1, new int[]{1}),
                Arguments.of("Example 3", new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2, new int[]{1, 2})
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provider")
    void testTopKFrequentV1(String message, int[] nums, int k, int[] expected) {
        var solution = new Solution();
        var result = solution.topKFrequentV1(nums, k);
        Arrays.sort(result);
        Arrays.sort(expected);
        assertArrayEquals(expected, result);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provider")
    void testTopKFrequentV2(String message, int[] nums, int k, int[] expected) {
        var solution = new Solution();
        var result = solution.topKFrequentV2(nums, k);
        Arrays.sort(result);
        Arrays.sort(expected);
        assertArrayEquals(expected, result);
    }
}
