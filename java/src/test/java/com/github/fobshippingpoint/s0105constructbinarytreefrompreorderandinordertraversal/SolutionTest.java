package com.github.fobshippingpoint.s0105constructbinarytreefrompreorderandinordertraversal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    public static final Solution solution = new Solution();

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should return [3,9,20,null,null,15,7] for preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]",
                        new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}, new Integer[]{3, 9, 20, null, null, 15, 7}),
                Arguments.of("Should return [-1] for preorder = [-1], inorder = [-1]",
                        new int[]{-1}, new int[]{-1}, new Integer[]{-1})
        );
    }

    private static Integer[] treeToArray(Solution.TreeNode root) {
        if (root == null) {
            return new Integer[]{};
        }

        var values = new ArrayList<Integer>();
        var queue = new LinkedList<Solution.TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var node = queue.remove();
            if (node == null) {
                values.add(null);
            } else {
                values.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        while (!values.isEmpty() && values.getLast() == null) {
            values.removeLast();
        }
        return values.toArray(Integer[]::new);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testBuildTreeV1(String message, int[] preorder, int[] inorder, Integer[] expect) {
        var result = solution.buildTreeV1(preorder, inorder);
        assertArrayEquals(expect, treeToArray(result), message);
    }

    @ParameterizedTest
    @MethodSource("provider")
    public void testBuildTreeV2(String message, int[] preorder, int[] inorder, Integer[] expect) {
        var result = solution.buildTreeV2(preorder, inorder);
        assertArrayEquals(expect, treeToArray(result), message);
    }

}
