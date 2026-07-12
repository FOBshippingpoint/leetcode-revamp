package com.github.fobshippingpoint.s0621taskscheduler;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return 8 with a cooling interval of 2",
                        new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2, 8),
                Arguments.of("Should return 6 with a cooling interval of 1",
                        new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 1, 6),
                Arguments.of("Should return 10 with a cooling interval of 3",
                        new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testLeastIntervalV1(String message, char[] tasks, int n, int expect) {
        assertEquals(expect, new Solution().leastInterval(tasks, n), message);
    }

}
