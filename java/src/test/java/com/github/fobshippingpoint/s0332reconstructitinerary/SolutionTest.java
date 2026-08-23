package com.github.fobshippingpoint.s0332reconstructitinerary;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should reconstruct the itinerary across all tickets in lexical order",
                        List.of(
                                List.of("MUC", "LHR"),
                                List.of("JFK", "MUC"),
                                List.of("SFO", "SJC"),
                                List.of("LHR", "SFO")
                        ),
                        List.of("JFK", "MUC", "LHR", "SFO", "SJC")),
                Arguments.of("Should choose the lexical smallest valid itinerary when multiple paths exist",
                        List.of(
                                List.of("JFK", "SFO"),
                                List.of("JFK", "ATL"),
                                List.of("SFO", "ATL"),
                                List.of("ATL", "JFK"),
                                List.of("ATL", "SFO")
                        ),
                        List.of("JFK", "ATL", "JFK", "SFO", "ATL", "SFO"))
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testFindItineraryV1(String message, List<List<String>> tickets, List<String> expect) {
        assertEquals(expect, new Solution().findItinerary(tickets), message);
    }

}
