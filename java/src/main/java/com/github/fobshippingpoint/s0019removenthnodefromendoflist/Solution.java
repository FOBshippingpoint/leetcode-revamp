package com.github.fobshippingpoint.s0019removenthnodefromendoflist;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEndV1(ListNode head, int n) {
        var dummy = new ListNode(-1, head);
        var left = dummy;
        var right = head;

        // Move right n steps ahead of left.
        while (n > 0 && right != null) {
            right = right.next;
            n -= 1;
        }

        // Move both pointers forward until right reaches the end.
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        // Remove the target node by skipping left.next.
        left.next = left.next.next;
        return dummy.next;
    }

}


