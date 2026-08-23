package com.github.fobshippingpoint.s0127wordladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should find the shortest transformation sequence",
                        "hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"), 5),
                Arguments.of("Should return zero when the end word is absent",
                        "hit", "cog", List.of("hot", "dot", "dog", "lot", "log"), 0),
                Arguments.of("Should return zero when no one-letter transformation exists",
                        "hot", "dog", List.of("hot", "dog"), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testLadderLengthV1(String message, String beginWord, String endWord,
                            List<String> wordList, int expect) {
        assertEquals(expect, new Solution().ladderLength(beginWord, endWord, wordList), message);
    }

}
