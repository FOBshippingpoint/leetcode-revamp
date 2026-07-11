package com.github.fobshippingpoint.s1046laststoneweight;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return 1 for stones = [2,7,4,1,8,1]",
                        new int[]{2, 7, 4, 1, 8, 1}, 1),
                Arguments.of("Should return 1 for stones = [1]",
                        new int[]{1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testLastStoneWeightV1(String message, int[] stones, int expect) {
        assertEquals(expect, new Solution().lastStoneWeight(stones), message);
    }

}
