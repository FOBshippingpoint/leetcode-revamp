package com.github.fobshippingpoint.s0011containerwithmostwater;

public class Solution {

    public int maxArea(int[] height) {
        var left = 0;
        var right = height.length - 1;

        var maxAmount = 0;
        while (left < right) {
            var area = (right - left) * Math.min(height[left], height[right]);
            if (area > maxAmount) {
                maxAmount = area;
            }

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxAmount;
    }

}
