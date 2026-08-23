package com.github.fobshippingpoint.s0198houserobber;

public class Solution {

    public int rob(int[] nums) {
        var rob1 = 0;
        var rob2 = 0;

        // [rob1, rob2, n, n+1, ...]
        for (var n : nums) {
            // To rob this house     : rob1 + n
            // Not to rob this house : rob2
            var cur = Math.max(rob1 + n, rob2);
            rob1 = rob2;
            rob2 = cur;
        }
        return rob2;
    }

}
