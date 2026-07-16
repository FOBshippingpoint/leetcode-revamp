package com.github.fobshippingpoint.s0210coursescheduleii;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should order two courses by their prerequisite",
                        2, new int[][]{{1, 0}}),
                Arguments.of("Should return any valid order when multiple orders exist",
                        4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}),
                Arguments.of("Should return the only course when there are no prerequisites",
                        1, new int[][]{})
        );
    }

    private static void assertValidOrder(int numCourses, int[][] prerequisites,
                                         int[] order, String message) {
        assertEquals(numCourses, order.length, message);
        var positions = new int[numCourses];
        var seen = new boolean[numCourses];
        for (var position = 0; position < order.length; position++) {
            var course = order[position];
            assertTrue(course >= 0 && course < numCourses, message);
            assertFalse(seen[course], message);
            seen[course] = true;
            positions[course] = position;
        }
        for (var prerequisite : prerequisites) {
            assertTrue(positions[prerequisite[1]] < positions[prerequisite[0]], message);
        }
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testFindOrderV1(String message, int numCourses, int[][] prerequisites) {
        var order = new Solution().findOrder(numCourses, prerequisites);
        assertValidOrder(numCourses, prerequisites, order, message);
    }
}
