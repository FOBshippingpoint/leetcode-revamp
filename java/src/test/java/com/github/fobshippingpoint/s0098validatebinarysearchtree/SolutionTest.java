package com.github.fobshippingpoint.s0098validatebinarysearchtree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return true for root = [2,1,3]",
                        new Integer[]{2, 1, 3}, true),
                Arguments.of("Should return false for root = [5,1,4,null,null,3,6]",
                        new Integer[]{5, 1, 4, null, null, 3, 6}, false),
                Arguments.of("Should return false for root = [5,4,6,null,null,3,7]",
                        new Integer[]{5, 4, 6, null, null, 3, 7}, false),
                Arguments.of("Should return true for root = [2147483647]",
                        new Integer[]{2147483647}, true)
        );
    }

    private static Solution.TreeNode arrayToTree(Integer[] values) {
        if (values.length == 0 || values[0] == null) {
            return null;
        }

        var root = new Solution.TreeNode(values[0]);
        var queue = new ArrayDeque<Solution.TreeNode>();
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
    public void testIsValidBSTV1(String message, Integer[] root, boolean expect) {
        var result = solution.isValidBST(arrayToTree(root));
        assertEquals(expect, result, message);
    }

}
