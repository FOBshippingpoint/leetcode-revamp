package com.github.fobshippingpoint.s0002addtwonumbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return [7,0,8] for l1 = [2,4,3], l2 = [5,6,4]",
                        new int[]{2, 4, 3}, new int[]{5, 6, 4}, new int[]{7, 0, 8}),
                Arguments.of("Should return [0] for l1 = [0], l2 = [0]",
                        new int[]{0}, new int[]{0}, new int[]{0}),
                Arguments.of("Should return [8,9,9,9,0,0,0,1] for l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]",
                        new int[]{9, 9, 9, 9, 9, 9, 9}, new int[]{9, 9, 9, 9}, new int[]{8, 9, 9, 9, 0, 0, 0, 1})
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
    public void testAddTwoNumbersV1(String message, int[] l1, int[] l2, int[] expect) {
        var result = solution.addTwoNumbersV1(arrayToList(l1), arrayToList(l2));
        assertArrayEquals(expect, listToArray(result), message);
    }

}
