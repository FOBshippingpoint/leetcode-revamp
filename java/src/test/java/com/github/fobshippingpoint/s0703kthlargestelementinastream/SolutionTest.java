package com.github.fobshippingpoint.s0703kthlargestelementinastream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return [4,5,5,8,8] for k = 3, nums = [4,5,8,2]",
                        3, new int[]{4, 5, 8, 2}, new int[]{3, 5, 10, 9, 4}, new int[]{4, 5, 5, 8, 8}),
                Arguments.of("Should return [7,7,7,8] for k = 4, nums = [7,7,7,7,8,3]",
                        4, new int[]{7, 7, 7, 7, 8, 3}, new int[]{2, 10, 9, 9}, new int[]{7, 7, 7, 8})
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testKthLargestV1(String message, int k, int[] nums, int[] values, int[] expect) {
        var kthLargest = new Solution.KthLargest(k, nums);
        var result = Arrays.stream(values).map(kthLargest::add).toArray();
        assertArrayEquals(expect, result, message);
    }

}
