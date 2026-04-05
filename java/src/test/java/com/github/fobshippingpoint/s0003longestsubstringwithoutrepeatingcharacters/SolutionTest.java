package com.github.fobshippingpoint.s0003longestsubstringwithoutrepeatingcharacters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return 3 for s = 'abcabcbb'",
                        "abcabcbb", 3),
                Arguments.of("Should return 1 for s = 'bbbbb'",
                        "bbbbb", 1),
                Arguments.of("Should return 3 for s = 'pwwkew'",
                        "pwwkew", 3),
                Arguments.of("Should return 0 for s = ''",
                        "", 0),
                Arguments.of("Should return 0 for s = 'x'",
                        "x", 1),
                Arguments.of("Should return 0 for s = 'au'",
                        "au", 2),
                Arguments.of("Should return 0 for s = 'dvdf'",
                        "dvdf", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testLengthOfLongestSubstringV1(String message, String s, int expect) {
        var result = solution.lengthOfLongestSubstringV1(s);
        assertEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testLengthOfLongestSubstringV2(String message, String s, int expect) {
        var result = solution.lengthOfLongestSubstringV2(s);
        assertEquals(expect, result, message);
    }

}
