package com.github.fobshippingpoint.s0297serializeanddeserializebinarytree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("Should round-trip root = [1,2,3,null,null,4,5]",
                        new Integer[]{1, 2, 3, null, null, 4, 5}),
                Arguments.of("Should round-trip root = []",
                        new Integer[]{})
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
    public void testCodecV1(String message, Integer[] root) {
        var codec = new Solution.Codec();
        var serialized = codec.serialize(arrayToTree(root));
        var result = codec.deserialize(serialized);
        assertArrayEquals(root, treeToArray(result), message);
    }

}
