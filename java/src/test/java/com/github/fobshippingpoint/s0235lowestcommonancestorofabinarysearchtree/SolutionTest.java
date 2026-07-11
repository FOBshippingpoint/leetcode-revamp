package com.github.fobshippingpoint.s0235lowestcommonancestorofabinarysearchtree;

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
                Arguments.of("Should return 6 for root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8",
                        new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}, 2, 8, 6),
                Arguments.of("Should return 2 for root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4",
                        new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}, 2, 4, 2),
                Arguments.of("Should return 2 for root = [2,1], p = 2, q = 1",
                        new Integer[]{2, 1}, 2, 1, 2)
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

    private static Solution.TreeNode findNode(Solution.TreeNode root, int value) {
        var curr = root;
        while (curr != null) {
            if (curr.val == value) {
                return curr;
            } else if (value < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return null;
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testLowestCommonAncestorV1(String message, Integer[] rootValues, int pValue, int qValue, int expect) {
        var root = arrayToTree(rootValues);
        var p = findNode(root, pValue);
        var q = findNode(root, qValue);
        var result = solution.lowestCommonAncestor(root, p, q);
        assertEquals(expect, result.val, message);
    }

}
