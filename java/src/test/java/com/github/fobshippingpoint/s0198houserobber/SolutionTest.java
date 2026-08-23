package com.github.fobshippingpoint.s0198houserobber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should rob non-adjacent houses for the best total",
                        new int[]{1, 2, 3, 1}, 4),
                Arguments.of("Should pick the optimal alternating houses",
                        new int[]{2, 7, 9, 3, 1}, 12),
                Arguments.of("Should handle a single house",
                        new int[]{5}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testRobV1(String message, int[] nums, int expect) {
        assertEquals(expect, new Solution().rob(nums), message);
    }

}
