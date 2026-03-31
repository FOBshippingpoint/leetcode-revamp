package com.github.fobshippingpoint.s0347topkfrequentelements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return [1,2] since 1 occurs 3 times and 2 occurs 2 times.",
                        new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2}),
                Arguments.of("Should return [1] since 1 is the only element.",
                        new int[]{1}, 1, new int[]{1}),
                Arguments.of("Should return [1,2] since 1 and 2 both occur 4 times.",
                        new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2, new int[]{1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testTopKFrequentV1(String message, int[] nums, int k, int[] expected) {
        var solution = new Solution();
        var result = solution.topKFrequentV1(nums, k);
        assertEquals(Arrays.stream(expected).boxed().toList(), Arrays.stream(result).boxed().toList(), message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testTopKFrequentV2(String message, int[] nums, int k, int[] expected) {
        var solution = new Solution();
        var result = solution.topKFrequentV2(nums, k);
        assertEquals(Arrays.stream(expected).boxed().toList(), Arrays.stream(result).boxed().toList(), message);
    }

}
