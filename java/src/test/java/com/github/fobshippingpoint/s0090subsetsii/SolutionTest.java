package com.github.fobshippingpoint.s0090subsetsii;

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
                Arguments.of("Should return all unique subsets of [1,2,2]",
                        new int[]{1, 2, 2},
                        List.of(List.of(), List.of(1), List.of(1, 2),
                                List.of(1, 2, 2), List.of(2), List.of(2, 2))),
                Arguments.of("Should return all unique subsets of [0]",
                        new int[]{0}, List.of(List.of(), List.of(0)))
        );
    }

    private static List<List<Integer>> normalized(List<List<Integer>> subsets) {
        var result = new ArrayList<List<Integer>>();
        for (var subset : subsets) {
            var sortedSubset = new ArrayList<>(subset);
            sortedSubset.sort(Integer::compareTo);
            result.add(sortedSubset);
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
    void testSubsetsWithDupV1(String message, int[] nums, List<List<Integer>> expect) {
        var result = new Solution().subsetsWithDup(nums);
        assertEquals(normalized(expect), normalized(result), message);
    }

}
