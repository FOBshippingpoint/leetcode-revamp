package com.github.fobshippingpoint.s0046permutations;

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
                Arguments.of("Should return all permutations of [1,2,3]",
                        new int[]{1, 2, 3},
                        List.of(List.of(1, 2, 3), List.of(1, 3, 2),
                                List.of(2, 1, 3), List.of(2, 3, 1),
                                List.of(3, 1, 2), List.of(3, 2, 1))),
                Arguments.of("Should return all permutations of [0,1]",
                        new int[]{0, 1}, List.of(List.of(0, 1), List.of(1, 0))),
                Arguments.of("Should return the only permutation of [1]",
                        new int[]{1}, List.of(List.of(1)))
        );
    }

    private static List<List<Integer>> normalized(List<List<Integer>> permutations) {
        var result = new ArrayList<List<Integer>>();
        for (var permutation : permutations) {
            result.add(List.copyOf(permutation));
        }
        result.sort((left, right) -> {
            for (var i = 0; i < Math.min(left.size(), right.size()); i++) {
                var valueComparison = Integer.compare(left.get(i), right.get(i));
                if (valueComparison != 0) {
                    return valueComparison;
                }
            }
            return Integer.compare(left.size(), right.size());
        });
        return result;
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testPermuteV1(String message, int[] nums, List<List<Integer>> expect) {
        var result = new Solution().permuteV1(nums);
        assertEquals(normalized(expect), normalized(result), message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testPermuteV2(String message, int[] nums, List<List<Integer>> expect) {
        var result = new Solution().permuteV2(nums);
        assertEquals(normalized(expect), normalized(result), message);
    }

}
