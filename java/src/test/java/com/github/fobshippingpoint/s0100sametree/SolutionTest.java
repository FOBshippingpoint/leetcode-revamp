package com.github.fobshippingpoint.s0100sametree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return true for p = [1,2,3], q = [1,2,3]",
                        new Integer[]{1, 2, 3}, new Integer[]{1, 2, 3}, true),
                Arguments.of("Should return false for p = [1,2], q = [1,null,2]",
                        new Integer[]{1, 2}, new Integer[]{1, null, 2}, false),
                Arguments.of("Should return false for p = [1,2,1], q = [1,1,2]",
                        new Integer[]{1, 2, 1}, new Integer[]{1, 1, 2}, false)
        );
    }

    private static Solution.TreeNode arrayToTree(Integer[] values) {
        if (values.length == 0 || values[0] == null) {
            return null;
        }

        var root = new Solution.TreeNode(values[0]);
        var queue = new java.util.ArrayDeque<Solution.TreeNode>();
        queue.add(root);

        var i = 1;
        while (!queue.isEmpty() && i < values.length) {
            var node = queue.remove();
            if (values[i] != null) {
                node.left = new Solution.TreeNode(values[i]);
                queue.add(node.left);
            }
            i++;

            if (i < values.length && values[i] != null) {
                node.right = new Solution.TreeNode(values[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testIsSameTreeV1(String message, Integer[] p, Integer[] q, boolean expect) {
        var result = solution.isSameTree(arrayToTree(p), arrayToTree(q));
        assertEquals(expect, result, message);
    }

}
