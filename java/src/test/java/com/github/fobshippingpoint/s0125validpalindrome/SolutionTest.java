package com.github.fobshippingpoint.s0125validpalindrome;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should be palindrome since amanaplanacanalpanama",
                        "A man, a plan, a canal: Panama", true),
                Arguments.of("Should not be palindrome since raceacar",
                        "race a car", false),
                Arguments.of("Should be palindrome since empty string after normalization",
                        " ", true),
                Arguments.of("Should be palindrome since aba",
                        "ab_a", true),
                Arguments.of("Should be palindrome since x",
                        "x", true)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testIsPalindromeV1(String message, String s, boolean expect) {
        var result = solution.isPalindromeV1(s);
        assertEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testIsPalindromeV2(String message, String s, boolean expect) {
        var result = solution.isPalindromeV2(s);
        assertEquals(expect, result, message);
    }

}
