package com.github.fobshippingpoint.s0215kthlargestelementinanarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return 5 for k = 2",
                        new int[]{3, 2, 1, 5, 6, 4}, 2, 5),
                Arguments.of("Should return 4 for k = 4",
                        new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4),
                Arguments.of("Should return the only element when the array has length one",
                        new int[]{1}, 1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testFindKthLargestV1(String message, int[] nums, int k, int expect) {
        assertEquals(expect, new Solution().findKthLargestV1(nums, k), message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testFindKthLargestV2(String message, int[] nums, int k, int expect) {
        assertEquals(expect, new Solution().findKthLargestV2(nums, k), message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testFindKthLargestV3(String message, int[] nums, int k, int expect) {
        assertEquals(expect, new Solution().findKthLargestV3(nums, k), message);
    }

}
