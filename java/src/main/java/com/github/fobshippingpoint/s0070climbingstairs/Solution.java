package com.github.fobshippingpoint.s0070climbingstairs;

public class Solution {

    public int climbStairsV1(int n) {
        return countWays(0, n);
    }

    private int countWays(int curr, int n) {
        if (curr == n) {
            return 1;
        } else if (curr > n) {
            return 0;
        }
        return countWays(curr + 1, n) + countWays(curr + 2, n);
    }

    public int climbStairsV2(int n) {
        var one = 1;
        var two = 1;
        for (var i = 0; i < n - 1; i++) {
            var tmp = one;
            one = one + two;
            two = tmp;
        }
        return one;
    }

}
