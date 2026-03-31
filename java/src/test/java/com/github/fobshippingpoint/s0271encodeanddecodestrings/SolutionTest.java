package com.github.fobshippingpoint.s0271encodeanddecodestrings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should encode and decode Hello World",
                        List.of("Hello", "World")),
                Arguments.of("Should handle empty string",
                        List.of("")),
                Arguments.of("Should handle multiple empty strings",
                        List.of("", "")),
                Arguments.of("Should handle single element list",
                        List.of("test")),
                Arguments.of("Should handle strings with special chars",
                        List.of("a;b", "c;d")),
                Arguments.of("Should handle strings containing numbers",
                        List.of("123", "456"))
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testEncodeDecodeStringsV1(String message, java.util.List<String> strs) {
        var solution = new Solution();
        var encoded = solution.encodeV1(strs);
        var decoded = solution.decodeV1(encoded);
        assertEquals(strs, decoded, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testEncodeDecodeStringsV2(String message, java.util.List<String> strs) {
        var solution = new Solution();
        var encoded = solution.encodeV2(strs);
        var decoded = solution.decodeV2(encoded);
        assertEquals(strs, decoded, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testEncodeDecodeStringsV3(String message, java.util.List<String> strs) {
        var solution = new Solution();
        var encoded = solution.encodeV3(strs);
        var decoded = solution.decodeV3(encoded);
        assertEquals(strs, decoded, message);
    }

}
