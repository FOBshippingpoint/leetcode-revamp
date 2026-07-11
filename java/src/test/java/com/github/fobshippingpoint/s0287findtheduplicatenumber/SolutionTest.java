package com.github.fobshippingpoint.s0287findtheduplicatenumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return 2 for nums = [1,3,4,2,2]",
                        new int[]{1, 3, 4, 2, 2}, 2),
                Arguments.of("Should return 3 for nums = [3,1,3,4,2]",
                        new int[]{3, 1, 3, 4, 2}, 3),
                Arguments.of("Should return 3 for nums = [3,3,3,3,3]",
                        new int[]{3, 3, 3, 3, 3}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testFindDuplicateV1V1(String message, int[] nums, int expect) {
        var result = solution.findDuplicateV1(nums);
        assertEquals(expect, result, message);
    }

}
