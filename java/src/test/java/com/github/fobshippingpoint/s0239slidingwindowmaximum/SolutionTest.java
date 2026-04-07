package com.github.fobshippingpoint.s0239slidingwindowmaximum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return [3,3,5,5,6,7] for nums = [1,3,-1,-3,5,3,6,7], k = 3",
                        new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7}),
                Arguments.of("Should return [1] for nums = [1], k = 1",
                        new int[]{1}, 1, new int[]{1}),
                Arguments.of("Should return [1,-1] for nums = [1,-1], k = 1",
                        new int[]{1, -1}, 1, new int[]{1, -1})
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testMaxSlidingWindowV1(String message, int[] nums, int k, int[] expect) {
        var result = solution.maxSlidingWindowV1(nums, k);
        assertArrayEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testMaxSlidingWindowV2(String message, int[] nums, int k, int[] expect) {
        var result = solution.maxSlidingWindowV2(nums, k);
        assertArrayEquals(expect, result, message);
    }

}
