package com.github.fobshippingpoint.s0704binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return 4 for nums = [-1,0,3,5,9,12], target = 9",
                        new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
                Arguments.of("Should return -1 for nums = [-1,0,3,5,9,12], target = 2",
                        new int[]{-1, 0, 3, 5, 9, 12}, 2, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testSearchV1(String message, int[] nums, int target, int expect) {
        var result = solution.searchV1(nums, target);
        assertEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testSearchV2(String message, int[] nums, int target, int expect) {
        var result = solution.searchV2(nums, target);
        assertEquals(expect, result, message);
    }

}
