package com.github.fobshippingpoint.s1143longestcommonsubsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return the length of the common subsequence ace",
                        "abcde", "ace", 3),
                Arguments.of("Should return the full length when both strings match",
                        "abc", "abc", 3),
                Arguments.of("Should return 0 when there is no common subsequence",
                        "abc", "def", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testLongestCommonSubsequenceV1(String message, String text1, String text2, int expect) {
        assertEquals(expect, new Solution().longestCommonSubsequence(text1, text2), message);
    }

}
