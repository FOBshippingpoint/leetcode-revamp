package com.github.fobshippingpoint.s1768mergestringsalternately;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should alternate letters when both strings have the same length",
                        "abc", "pqr", "apbqcr"),
                Arguments.of("Should append the extra suffix from the longer second string",
                        "ab", "pqrs", "apbqrs"),
                Arguments.of("Should append the extra suffix from the longer first string",
                        "abcd", "pq", "apbqcd")
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testMergeAlternatelyV1(String message, String word1, String word2, String expect) {
        assertEquals(expect, new Solution().mergeAlternately(word1, word2), message);
    }

}
