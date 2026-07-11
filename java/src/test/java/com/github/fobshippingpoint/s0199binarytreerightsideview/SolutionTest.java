package com.github.fobshippingpoint.s0199binarytreerightsideview;

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
                Arguments.of("Should return [1,3,4] for root = [1,2,3,null,5,null,4]",
                        new Integer[]{1, 2, 3, null, 5, null, 4}, List.of(1, 3, 4)),
                Arguments.of("Should return [1,3,4,5] for root = [1,2,3,4,null,null,null,5]",
                        new Integer[]{1, 2, 3, 4, null, null, null, 5}, List.of(1, 3, 4, 5)),
                Arguments.of("Should return [1,3] for root = [1,null,3]",
                        new Integer[]{1, null, 3}, List.of(1, 3)),
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
    public void testRightSideViewV1(String message, Integer[] root, List<Integer> expect) {
        var result = solution.rightSideView(arrayToTree(root));
        assertEquals(expect, result, message);
    }

}
