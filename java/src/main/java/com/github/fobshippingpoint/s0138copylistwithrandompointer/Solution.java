package com.github.fobshippingpoint.s0138copylistwithrandompointer;

import java.util.HashMap;

public class Solution {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomListV1(Node head) {
        // <old, copy> map, convenient helper for getting the copy node from the old node.
        var oldToCopy = new HashMap<Node, Node>();
        var current = head;
        Node copy;

        // First pass: copy only the value without pointer.
        while (current != null) {
            copy = new Node(current.val);
            oldToCopy.put(current, copy);
            current = current.next;
        }

        // Second pass: connecting the pointers to the copy nodes.
        current = head;
        while (current != null) {
            copy = oldToCopy.get(current);
            copy.next = oldToCopy.get(current.next);
            copy.random = oldToCopy.get(current.random);
            current = current.next;
        }

        return oldToCopy.get(head);
    }

}
