package com.github.fobshippingpoint.s0238productofarrayexceptself;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return [24,12,8,6]",
                        new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                Arguments.of("Should return [0,0,9,0,0]",
                        new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0})
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provider")
    void testProductExceptSelfV1(String message, int[] nums, int[] expected) {
        var result = solution.productExceptSelfV1(nums);
        assertArrayEquals(expected, result);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provider")
    void testProductExceptSelfV2(String message, int[] nums, int[] expected) {
        var result = solution.productExceptSelfV2(nums);
        assertArrayEquals(expected, result);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provider")
    void testProductExceptSelfV3(String message, int[] nums, int[] expected) {
        var result = solution.productExceptSelfV3(nums);
        assertArrayEquals(expected, result);
    }

}
