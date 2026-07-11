package com.github.fobshippingpoint.s0230kthsmallestelementinabst;

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
                Arguments.of("Should return 1 for root = [3,1,4,null,2], k = 1",
                        new Integer[]{3, 1, 4, null, 2}, 1, 1),
                Arguments.of("Should return 3 for root = [5,3,6,2,4,null,null,1], k = 3",
                        new Integer[]{5, 3, 6, 2, 4, null, null, 1}, 3, 3)
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
    public void testKthSmallestV1(String message, Integer[] root, int k, int expect) {
        var result = solution.kthSmallestV1(arrayToTree(root), k);
        assertEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testKthSmallestV2(String message, Integer[] root, int k, int expect) {
        var result = solution.kthSmallestV2(arrayToTree(root), k);
        assertEquals(expect, result, message);
    }

}
