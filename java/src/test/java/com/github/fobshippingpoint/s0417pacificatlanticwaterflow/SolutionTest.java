package com.github.fobshippingpoint.s0417pacificatlanticwaterflow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return cells that can reach both oceans",
                        new int[][]{
                                {1, 2, 2, 3, 5},
                                {3, 2, 3, 4, 4},
                                {2, 4, 5, 3, 1},
                                {6, 7, 1, 4, 5},
                                {5, 1, 1, 2, 4}
                        },
                        List.of(
                                List.of(0, 4),
                                List.of(1, 3),
                                List.of(1, 4),
                                List.of(2, 2),
                                List.of(3, 0),
                                List.of(3, 1),
                                List.of(4, 0)
                        )),
                Arguments.of("Should return the only cell for a one-cell island",
                        new int[][]{{1}}, List.of(List.of(0, 0)))
        );
    }

    private static List<List<Integer>> normalized(List<List<Integer>> coordinates) {
        var result = new ArrayList<>(coordinates);
        result.sort(Comparator.comparingInt((List<Integer> left) -> left.getFirst()).thenComparingInt(left -> left.get(1)));
        return result;
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testPacificAtlanticV1(String message, int[][] heights, List<List<Integer>> expect) {
        var result = new Solution().pacificAtlantic(heights);
        assertEquals(normalized(expect), normalized(result), message);
    }
}
