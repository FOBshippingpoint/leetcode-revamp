package com.github.fobshippingpoint.s0131palindromepartitioning;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return both palindrome partitions of aab",
                        "aab", List.of(List.of("a", "a", "b"), List.of("aa", "b"))),
                Arguments.of("Should return the single palindrome partition of a",
                        "a", List.of(List.of("a")))
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testPartitionV1(String message, String s, List<List<String>> expect) {
        assertEquals(expect, new Solution().partition(s), message);
    }

}
