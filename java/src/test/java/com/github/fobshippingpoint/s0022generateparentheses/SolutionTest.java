package com.github.fobshippingpoint.s0022generateparentheses;

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
                Arguments.of("Should return all well-formed parentheses for n = 3",
                        3, List.of("((()))", "(()())", "(())()", "()(())", "()()()")),
                Arguments.of("Should return the only pair for n = 1",
                        1, List.of("()"))
        );
    }

    private static List<String> sorted(List<String> parentheses) {
        var result = new ArrayList<>(parentheses);
        result.sort(String::compareTo);
        return result;
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testGenerateParenthesisV1(String message, int n, List<String> expect) {
        var result = new Solution().generateParenthesis(n);
        assertEquals(sorted(expect), sorted(result), message);
    }

}
