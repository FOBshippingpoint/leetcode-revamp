package com.github.fobshippingpoint.s0110balancedbinarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return true for root = [3,9,20,null,null,15,7]",
                        new Integer[]{3, 9, 20, null, null, 15, 7}, true),
                Arguments.of("Should return false for root = [1,2,2,3,3,null,null,4,4]",
                        new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4}, false),
                Arguments.of("Should return true for root = []",
                        new Integer[]{}, true)
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
    public void testIsBalancedV1(String message, Integer[] root, boolean expect) {
        var result = solution.isBalancedV1(arrayToTree(root));
        assertEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testIsBalancedV2(String message, Integer[] root, boolean expect) {
        var result = solution.isBalancedV2(arrayToTree(root));
        assertEquals(expect, result, message);
    }

}
