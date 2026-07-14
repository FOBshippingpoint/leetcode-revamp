package com.github.fobshippingpoint.s0017lettercombinationsofaphonenumber;

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
                Arguments.of("Should return all letter combinations for 23",
                        "23", List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
                Arguments.of("Should return all letter combinations for 2",
                        "2", List.of("a", "b", "c")),
                Arguments.of("Should return all letter combinations for empty digit",
                        "", List.of())
        );
    }

    private static List<String> normalized(List<String> combinations) {
        var result = new ArrayList<>(combinations);
        result.sort(String::compareTo);
        return result;
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testLetterCombinationsV1(String message, String digits, List<String> expect) {
        var result = new Solution().letterCombinations(digits);
        assertEquals(normalized(expect), normalized(result), message);
    }

}
