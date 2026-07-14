package com.github.fobshippingpoint.s0051nqueens;

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
                Arguments.of("Should return both solutions for n = 4", 4,
                        List.of(
                                List.of(".Q..", "...Q", "Q...", "..Q."),
                                List.of("..Q.", "Q...", "...Q", ".Q..")
                        )),
                Arguments.of("Should return the only solution for n = 1", 1,
                        List.of(List.of("Q")))
        );
    }

    private static List<List<String>> normalized(List<List<String>> boards) {
        var result = new ArrayList<List<String>>();
        for (var board : boards) {
            result.add(List.copyOf(board));
        }
        result.sort((left, right) -> {
            for (var i = 0; i < Math.min(left.size(), right.size()); i++) {
                var rowComparison = left.get(i).compareTo(right.get(i));
                if (rowComparison != 0) {
                    return rowComparison;
                }
            }
            return Integer.compare(left.size(), right.size());
        });
        return result;
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testSolveNQueensV1(String message, int n, List<List<String>> expect) {
        var result = new Solution().solveNQueens(n);
        assertEquals(normalized(expect), normalized(result), message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testSolveNQueensV2(String message, int n, List<List<String>> expect) {
        var result = new Solution().solveNQueensV2(n);
        assertEquals(normalized(expect), normalized(result), message);
    }

}
