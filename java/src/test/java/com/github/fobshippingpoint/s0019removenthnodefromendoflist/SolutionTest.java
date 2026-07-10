package com.github.fobshippingpoint.s0019removenthnodefromendoflist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return [1,2,3,5] for head = [1,2,3,4,5], n = 2",
                        new int[]{1, 2, 3, 4, 5}, 2, new int[]{1, 2, 3, 5}),
                Arguments.of("Should return [] for head = [1], n = 1",
                        new int[]{1}, 1, new int[]{}),
                Arguments.of("Should return [1] for head = [1,2], n = 1",
                        new int[]{1, 2}, 1, new int[]{1})
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
    public void testRemoveNthFromEndV1V1(String message, int[] head, int n, int[] expect) {
        var result = solution.removeNthFromEndV1(arrayToList(head), n);
        assertArrayEquals(expect, listToArray(result), message);
    }

}
