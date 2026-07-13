package com.github.fobshippingpoint.s0079wordsearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should find ABCCED",
                        new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'},
                                {'A', 'D', 'E', 'E'}}, "ABCCED", true),
                Arguments.of("Should find SEE",
                        new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'},
                                {'A', 'D', 'E', 'E'}}, "SEE", true),
                Arguments.of("Should not reuse a cell to find ABCB",
                        new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'},
                                {'A', 'D', 'E', 'E'}}, "ABCB", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testExistV1(String message, char[][] board, String word, boolean expect) {
        assertEquals(expect, new Solution().exist(board, word), message);
    }

}
