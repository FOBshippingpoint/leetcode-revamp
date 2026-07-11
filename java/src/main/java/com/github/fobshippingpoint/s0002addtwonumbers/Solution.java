package com.github.fobshippingpoint.s0002addtwonumbers;

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

    public ListNode addTwoNumbersV1(ListNode l1, ListNode l2) {
        var dummy = new ListNode();
        var curr = dummy;

        var carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            var val1 = 0;
            var val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
            }
            if (l2 != null) {
                val2 = l2.val;
            }

            var val = val1 + val2 + carry;
            carry = val / 10;
            val = val % 10;
            curr.next = new ListNode(val);
            curr = curr.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }

}
