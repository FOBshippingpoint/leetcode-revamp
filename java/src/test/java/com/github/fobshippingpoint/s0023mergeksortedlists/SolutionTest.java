package com.github.fobshippingpoint.s0023mergeksortedlists;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return [1,1,2,3,4,4,5,6] for lists = [[1,4,5],[1,3,4],[2,6]]",
                        new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}}, new int[]{1, 1, 2, 3, 4, 4, 5, 6}),
                Arguments.of("Should return [] for lists = []",
                        new int[][]{}, new int[]{}),
                Arguments.of("Should return [] for lists = [[]]",
                        new int[][]{{}}, new int[]{})
        );
    }

    private static Solution.ListNode arrayToList(int[] values) {
        var dummy = new Solution.ListNode();
        var curr = dummy;
        for (var value : values) {
            curr.next = new Solution.ListNode(value);
            curr = curr.next;
        }
        return dummy.next;
    }

    private static Solution.ListNode[] arraysToLists(int[][] lists) {
        var result = new Solution.ListNode[lists.length];
        for (var i = 0; i < lists.length; i++) {
            result[i] = arrayToList(lists[i]);
        }
        return result;
    }

    private static int[] listToArray(Solution.ListNode head) {
        var count = 0;
        var curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        var values = new int[count];
        curr = head;
        for (var i = 0; i < count; i++) {
            values[i] = curr.val;
            curr = curr.next;
        }
        return values;
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testMergeKListsV1(String message, int[][] lists, int[] expect) {
        var result = solution.mergeKLists(arraysToLists(lists));
        assertArrayEquals(expect, listToArray(result), message);
    }

}
