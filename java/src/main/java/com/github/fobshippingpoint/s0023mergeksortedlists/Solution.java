package com.github.fobshippingpoint.s0023mergeksortedlists;

import java.util.ArrayList;

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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {
            var merged = new ArrayList<ListNode>();

            for (int i = 0; i < lists.length; i += 2) {
                var l1 = lists[i];
                var l2 = i + 1 < lists.length ? lists[i + 1] : null;
                merged.add(mergeTwoLists(l1, l2));
            }
            lists = merged.toArray(ListNode[]::new);
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var dummy = new ListNode();
        var tail = dummy;

        while (list1 != null && list2 != null) {
            // Connect the smaller node, and advanced by 1
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Connecting the remaining nodes of whichever list is not empty
        tail.next = list1 != null ? list1 : list2;
        return dummy.next;
    }

}
