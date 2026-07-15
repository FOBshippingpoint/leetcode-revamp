package com.github.fobshippingpoint.s0133clonegraph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should clone a graph with four connected nodes",
                        List.of(List.of(2, 4), List.of(1, 3), List.of(2, 4), List.of(1, 3))),
                Arguments.of("Should clone a single node without neighbors",
                        List.of(List.of())),
                Arguments.of("Should clone an empty graph",
                        List.of())
        );
    }

    private static Solution.Node buildGraph(List<List<Integer>> adjacencyList) {
        var nodes = new ArrayList<Solution.Node>();
        for (var i = 0; i < adjacencyList.size(); i++) {
            nodes.add(new Solution.Node(i + 1));
        }
        for (var i = 0; i < adjacencyList.size(); i++) {
            for (var neighbor : adjacencyList.get(i)) {
                nodes.get(i).neighbors.add(nodes.get(neighbor - 1));
            }
        }
        return nodes.isEmpty() ? null : nodes.get(0);
    }

    private static Map<Integer, Solution.Node> nodesByValue(Solution.Node node) {
        var nodes = new HashMap<Integer, Solution.Node>();
        visit(node, nodes);
        return nodes;
    }

    private static void visit(Solution.Node node, Map<Integer, Solution.Node> nodes) {
        if (node == null || nodes.putIfAbsent(node.val, node) != null) {
            return;
        }
        node.neighbors.forEach(neighbor -> visit(neighbor, nodes));
    }

    private static List<List<Integer>> adjacencyList(Solution.Node node) {
        var nodes = nodesByValue(node);
        var result = new ArrayList<List<Integer>>();
        for (var value = 1; value <= nodes.size(); value++) {
            result.add(nodes.get(value).neighbors.stream().map(neighbor -> neighbor.val).sorted().toList());
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("provider")
    void testCloneGraphV1(String message, List<List<Integer>> adjacencyList) {
        var original = buildGraph(adjacencyList);
        var cloned = new Solution().cloneGraph(original);

        assertEquals(adjacencyList, adjacencyList(cloned), message);
        var originalNodes = nodesByValue(original);
        var clonedNodes = nodesByValue(cloned);
        for (var value : originalNodes.keySet()) {
            assertNotSame(originalNodes.get(value), clonedNodes.get(value), message);
            assertNotSame(originalNodes.get(value).neighbors, clonedNodes.get(value).neighbors, message);
        }
    }
}
