package com.github.fobshippingpoint.s0572subtreeofanothertree;

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
                Arguments.of("Should return true for root = [3,4,5,1,2], subRoot = [4,1,2]",
                        new Integer[]{3, 4, 5, 1, 2}, new Integer[]{4, 1, 2}, true),
                Arguments.of("Should return false for root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]",
                        new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0}, new Integer[]{4, 1, 2}, false)
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
    public void testIsSubtreeV1(String message, Integer[] root, Integer[] subRoot, boolean expect) {
        var result = solution.isSubtreeV1(arrayToTree(root), arrayToTree(subRoot));
        assertEquals(expect, result, message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testIsSubtreeV2(String message, Integer[] root, Integer[] subRoot, boolean expect) {
        var result = solution.isSubtreeV2(arrayToTree(root), arrayToTree(subRoot));
        assertEquals(expect, result, message);
    }

}
