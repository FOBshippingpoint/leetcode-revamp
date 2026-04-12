package com.github.fobshippingpoint.s0704binarysearch;

import java.util.Arrays;

public class Solution {

    public int searchV1(int[] nums, int target) {
        var idx = Arrays.binarySearch(nums, target);
        return idx >= 0 ? idx : -1;
    }

    public int searchV2(int[] nums, int target) {
        var low = 0;
        var high = nums.length;

        while (low < high) {
            var mid = (low + high) >>> 1; // unsigned right shift operator, like / 2
            var val = nums[mid];
            if (val < target) {
                low = mid + 1;
            } else if (val > target) {
                high = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
