package com.github.fobshippingpoint.s0138copylistwithrandompointer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should copy [[7,null],[13,0],[11,4],[10,2],[1,0]]",
                        new int[]{7, 13, 11, 10, 1}, new Integer[]{null, 0, 4, 2, 0}),
                Arguments.of("Should copy [[1,1],[2,1]]",
                        new int[]{1, 2}, new Integer[]{1, 1}),
                Arguments.of("Should copy [[3,null],[3,0],[3,null]]",
                        new int[]{3, 3, 3}, new Integer[]{null, 0, null})
        );
    }

    private static Solution.Node arrayToList(int[] values, Integer[] randomIndexes) {
        var nodes = new Solution.Node[values.length];
        for (var i = 0; i < values.length; i++) {
            nodes[i] = new Solution.Node(values[i]);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }

        for (var i = 0; i < randomIndexes.length; i++) {
            if (randomIndexes[i] != null) {
                nodes[i].random = nodes[randomIndexes[i]];
            }
        }
        return nodes.length == 0 ? null : nodes[0];
    }

    private static String listToString(Solution.Node head) {
        var nodes = new ArrayList<Solution.Node>();
        var indexes = new HashMap<Solution.Node, Integer>();
        var curr = head;
        while (curr != null) {
            indexes.put(curr, nodes.size());
            nodes.add(curr);
            curr = curr.next;
        }

        var values = new ArrayList<String>();
        for (var node : nodes) {
            var randomIndex = node.random == null ? "null" : indexes.get(node.random).toString();
            values.add("[%d,%s]".formatted(node.val, randomIndex));
        }
        return values.toString();
    }

    private static void assertNoSharedNodes(Solution.Node original, Solution.Node copy, String message) {
        while (original != null && copy != null) {
            assertNotSame(original, copy, message);
            original = original.next;
            copy = copy.next;
        }
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testCopyRandomListV1V1(String message, int[] values, Integer[] randomIndexes) {
        var head = arrayToList(values, randomIndexes);
        var result = solution.copyRandomListV1(head);
        assertEquals(listToString(head), listToString(result), message);
        assertNoSharedNodes(head, result, message);
    }

}
