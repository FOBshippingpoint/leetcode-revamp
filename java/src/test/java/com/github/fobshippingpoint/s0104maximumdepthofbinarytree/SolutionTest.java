package com.github.fobshippingpoint.s0104maximumdepthofbinarytree;

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
                Arguments.of("Should return 3 for root = [3,9,20,null,null,15,7]",
                        new Integer[]{3, 9, 20, null, null, 15, 7}, 3),
                Arguments.of("Should return 2 for root = [1,null,2]",
                        new Integer[]{1, null, 2}, 2)
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
    public void testMaxDepthV1(String message, Integer[] root, int expect) {
        var result = solution.maxDepth(arrayToTree(root));
        assertEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testMaxDepthV2(String message, Integer[] root, int expect) {
        var result = solution.maxDepthV2(arrayToTree(root));
        assertEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testMaxDepthV3(String message, Integer[] root, int expect) {
        var result = solution.maxDepthV3(arrayToTree(root));
        assertEquals(expect, result, message);
    }

}
