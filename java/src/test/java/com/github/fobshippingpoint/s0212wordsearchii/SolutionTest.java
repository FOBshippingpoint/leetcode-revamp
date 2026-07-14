package com.github.fobshippingpoint.s0212wordsearchii;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should find eat and oath",
                        new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'},
                                {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
                        new String[]{"oath", "pea", "eat", "rain"},
                        List.of("eat", "oath")),
                Arguments.of("Should not reuse a cell to find abcb",
                        new char[][]{{'a', 'b'}, {'c', 'd'}},
                        new String[]{"abcb"}, List.of())
        );
    }

    private static List<String> sorted(List<String> words) {
        var result = new ArrayList<>(words);
        result.sort(String::compareTo);
        return result;
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testFindWordsV1(String message, char[][] board, String[] words,
                         List<String> expect) {
        var result = new Solution().findWords(board, words);
        assertEquals(sorted(expect), sorted(result), message);
    }

}
