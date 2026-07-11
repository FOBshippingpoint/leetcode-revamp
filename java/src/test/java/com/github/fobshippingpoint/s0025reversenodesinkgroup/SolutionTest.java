package com.github.fobshippingpoint.s0025reversenodesinkgroup;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return [2,1,4,3,5] for head = [1,2,3,4,5], k = 2",
                        new int[]{1, 2, 3, 4, 5}, 2, new int[]{2, 1, 4, 3, 5}),
                Arguments.of("Should return [3,2,1,4,5] for head = [1,2,3,4,5], k = 3",
                        new int[]{1, 2, 3, 4, 5}, 3, new int[]{3, 2, 1, 4, 5})
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
    public void testReverseKGroupV1(String message, int[] head, int k, int[] expect) {
        var result = solution.reverseKGroup(arrayToList(head), k);
        assertArrayEquals(expect, listToArray(result), message);
    }

}
