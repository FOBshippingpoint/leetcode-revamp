package com.github.fobshippingpoint.s0875kokoeatingbananas;

import java.util.Arrays;

public class Solution {

    public int minEatingSpeedV1(int[] piles, int h) {
        var low = 1;
        var high = Arrays.stream(piles).max().getAsInt();

        while (low < high) {
            var totalHours = 0;
            var mid = (low + high) >>> 1;
            for (var p : piles) {
                totalHours += (p + mid - 1) / mid;
            }

            if (totalHours <= h) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int minEatingSpeedV2(int[] piles, int h) {
        var low = 1;
        int high = 0;
        for (var p : piles) {
            if (p > high) high = p;
        }

        while (low < high) {
            var totalHours = 0;
            var mid = (low + high) >>> 1;
            for (var p : piles) {
                totalHours += (p + mid - 1) / mid;
            }

            if (totalHours <= h) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}