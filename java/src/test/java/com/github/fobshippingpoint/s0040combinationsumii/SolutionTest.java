package com.github.fobshippingpoint.s0040combinationsumii;

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
                Arguments.of("Should return four unique combinations for target 8",
                        new int[]{10, 1, 2, 7, 6, 1, 5}, 8,
                        List.of(List.of(1, 1, 6), List.of(1, 2, 5),
                                List.of(1, 7), List.of(2, 6))),
                Arguments.of("Should return two unique combinations for target 5",
                        new int[]{2, 5, 2, 1, 2}, 5,
                        List.of(List.of(1, 2, 2), List.of(5)))
        );
    }

    private static List<List<Integer>> normalized(List<List<Integer>> combinations) {
        var result = new ArrayList<List<Integer>>();
        for (var combination : combinations) {
            var sortedCombination = new ArrayList<>(combination);
            sortedCombination.sort(Integer::compareTo);
            result.add(sortedCombination);
        }
        result.sort((left, right) -> {
            var sizeComparison = Integer.compare(left.size(), right.size());
            if (sizeComparison != 0) {
                return sizeComparison;
            }
            for (var i = 0; i < left.size(); i++) {
                var valueComparison = Integer.compare(left.get(i), right.get(i));
                if (valueComparison != 0) {
                    return valueComparison;
                }
            }
            return 0;
        });
        return result;
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testCombinationSum2V1(String message, int[] candidates, int target,
                               List<List<Integer>> expect) {
        var result = new Solution().combinationSum2(candidates, target);
        assertEquals(normalized(expect), normalized(result), message);
    }

}
