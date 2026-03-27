package com.github.fobshippingpoint.s0217containsduplicate;

import java.util.HashSet;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        var set = new HashSet<Integer>();
        for (var n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }

}

