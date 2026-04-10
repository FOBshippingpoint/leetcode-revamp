package com.github.fobshippingpoint.s0150evaluatereversepolishnotation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return 9 for tokens [2,1,+,3,*]",
                        new String[]{"2", "1", "+", "3", "*"}, 9),
                Arguments.of("Should return 6 for tokens [4,13,5,/,+]",
                        new String[]{"4", "13", "5", "/", "+"}, 6),
                Arguments.of("Should return 22 for tokens [10,6,9,3,+,-11,*,/,*,17,+,5,+]",
                        new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testEvalRPNV1(String message, String[] tokens, int expect) {
        var result = solution.evalRPNV1(tokens);
        assertEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testEvalRPNV2(String message, String[] tokens, int expect) {
        var result = solution.evalRPNV2(tokens);
        assertEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testEvalRPNV3(String message, String[] tokens, int expect) {
        var result = solution.evalRPNV3(tokens);
        assertEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testEvalRPNV4(String message, String[] tokens, int expect) {
        var result = solution.evalRPNV4(tokens);
        assertEquals(expect, result, message);
    }

}
