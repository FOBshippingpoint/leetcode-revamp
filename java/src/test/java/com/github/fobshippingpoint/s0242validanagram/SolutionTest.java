package com.github.fobshippingpoint.s0242validanagram;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should be anagram since the chars type and count match",
                        "anagram", "nagaram", true),
                Arguments.of("Should not be anagram since the char t and c are not equal",
                        "rat", "car", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testIsAnagramV1(String message, String s, String t, boolean expect) {
        var result = solution.isAnagramV1(s, t);
        assertEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testIsAnagramV2(String message, String s, String t, boolean expect) {
        var result = solution.isAnagramV2(s, t);
        assertEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testIsAnagramV3(String message, String s, String t, boolean expect) {
        var result = solution.isAnagramV3(s, t);
        assertEquals(expect, result, message);
    }

}