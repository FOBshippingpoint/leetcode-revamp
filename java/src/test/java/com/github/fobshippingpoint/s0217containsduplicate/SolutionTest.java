package com.github.fobshippingpoint.s0217containsduplicate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should be duplicates since the element 1 occurs at the indices 0 and 3.",
                        new int[]{1, 2, 3, 1}, true),
                Arguments.of("Should not be duplicates since All elements are distinct.",
                        new int[]{1, 2, 3, 4}, false),
                Arguments.of("Should be duplicates since The element 1 occurs at the indices 0 and 1.",
                        new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testContainsDuplicate(String message, int[] nums, boolean expect) {
        var solution = new Solution();
        var result = solution.containsDuplicate(nums);
        assertEquals(expect, result, message);
    }

}