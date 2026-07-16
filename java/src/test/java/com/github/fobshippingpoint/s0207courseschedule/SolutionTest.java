package com.github.fobshippingpoint.s0207courseschedule;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should finish courses when prerequisites contain no cycle",
                        2, new int[][]{{1, 0}}, true),
                Arguments.of("Should finish courses when prerequisites contain no cycle",
                        5, new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}}, true),
                Arguments.of("Should not finish courses when prerequisites contain a cycle",
                        2, new int[][]{{1, 0}, {0, 1}}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testCanFinishV1(String message, int numCourses, int[][] prerequisites, boolean expect) {
        assertEquals(expect, new Solution().canFinish(numCourses, prerequisites), message);
    }
}
