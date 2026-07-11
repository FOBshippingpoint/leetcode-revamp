package com.github.fobshippingpoint.s0102binarytreelevelordertraversal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return [[3],[9,20],[15,7]] for root = [3,9,20,null,null,15,7]",
                        new Integer[]{3, 9, 20, null, null, 15, 7}, List.of(List.of(3), List.of(9, 20), List.of(15, 7))),
                Arguments.of("Should return [[1]] for root = [1]",
                        new Integer[]{1}, List.of(List.of(1))),
                Arguments.of("Should return [] for root = []",
                        new Integer[]{}, List.of())
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
    public void testLevelOrderV1(String message, Integer[] root, List<List<Integer>> expect) {
        var result = solution.levelOrder(arrayToTree(root));
        assertEquals(expect, result, message);
    }

}
