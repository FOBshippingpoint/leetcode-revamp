package com.github.fobshippingpoint.s0072editdistance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should transform horse to ros in three edits",
                        "horse", "ros", 3),
                Arguments.of("Should transform intention to execution in five edits",
                        "intention", "execution", 5),
                Arguments.of("Should return zero when both strings are already equal",
                        "abc", "abc", 0),
                Arguments.of("Should handle inserting all characters into an empty string",
                        "", "abc", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testMinDistanceV1(String message, String word1, String word2, int expect) {
        assertEquals(expect, new Solution().minDistance(word1, word2), message);
    }

}
