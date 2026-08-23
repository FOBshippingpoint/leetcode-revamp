package com.github.fobshippingpoint.s0151reversewordsinastring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should reverse the order of words in a basic sentence",
                        "the sky is blue", "blue is sky the"),
                Arguments.of("Should trim leading and trailing spaces while reversing words",
                        "  hello world  ", "world hello"),
                Arguments.of("Should collapse multiple spaces between words",
                        "a good   example", "example good a")
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testReverseWordsV1(String message, String s, String expect) {
        assertEquals(expect, new Solution().reverseWordsV1(s), message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testReverseWordsV2(String message, String s, String expect) {
        assertEquals(expect, new Solution().reverseWordsV2(s), message);
    }

}
