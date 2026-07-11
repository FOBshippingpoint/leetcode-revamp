package com.github.fobshippingpoint.s0025reversenodesinkgroup;

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

    // Example:
    //   1->2->3->4->5
    //   k = 3
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        var dummy = new ListNode();
        dummy.next = head;

        var groupBefore = dummy;

        while (true) {
            var kth = getKth(groupBefore, k);
            if (kth == null) {
                break; // break since we don't have k remaining nodes
            }

            var groupAfter = kth.next;

            // Reverse the group
            var prev = groupAfter;
            var curr = groupBefore.next;
            while (curr != groupAfter) {
                var next = curr.next;
                // At the 1st cycle, this will connect the current group to the next group
                // 1-x->2, 1->4
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // The group has been reversed, so groupBefore.next is now pointing at right
            //
            //   groupBefore       kth
            //        ▼             ▼
            //      dummy->3->2->1->4->5
            //                   ▲
            //            groupBefore.next
            var nextGroupBefore = groupBefore.next;
            groupBefore.next = kth; // Wire the before group with current group
            groupBefore = nextGroupBefore;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

}
