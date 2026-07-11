package com.github.fobshippingpoint.s0973kclosestpointstoorigin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return [[-2,2]] for k = 1",
                        new int[][]{{1, 3}, {-2, 2}}, 1,
                        new int[][]{{-2, 2}}),
                Arguments.of("Should return the two closest points for k = 2",
                        new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2,
                        new int[][]{{3, 3}, {-2, 4}})
        );
    }

    private static int[][] sorted(int[][] points) {
        var result = Arrays.stream(points).map(int[]::clone).toArray(int[][]::new);
        Arrays.sort(result, Comparator.comparingInt((int[] point) -> point[0])
                .thenComparingInt(point -> point[1]));
        return result;
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testKClosestV1(String message, int[][] points, int k, int[][] expect) {
        var result = new Solution().kClosestV1(points, k);
        assertArrayEquals(sorted(expect), sorted(result), message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testKClosestV2(String message, int[][] points, int k, int[][] expect) {
        var result = new Solution().kClosestV2(points, k);
        assertArrayEquals(sorted(expect), sorted(result), message);
    }

}
