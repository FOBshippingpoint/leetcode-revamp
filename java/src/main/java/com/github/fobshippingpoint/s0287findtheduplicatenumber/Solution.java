package com.github.fobshippingpoint.s0287findtheduplicatenumber;

public class Solution {

    public int findDuplicateV1(int[] nums) {
        var slow = 0;
        var fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        var head = 0;
        while (true) {
            slow = nums[slow];
            head = nums[head];
            if (slow == head) {
                return slow;
            }
        }
    }

}
