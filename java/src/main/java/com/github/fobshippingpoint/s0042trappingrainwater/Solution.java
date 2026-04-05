package com.github.fobshippingpoint.s0042trappingrainwater;

public class Solution {

    /**
     * <ol>
     * <li>Traverse from left to right, picking a currently highest pillar, and sums up the area until meet equal or higher pillar.
     * <li>Traverse from right to left, picking a currently highest pillar, and sums up the area until meet higher pillar.
     * </ol>
     */
    public int trapV1(int[] height) {
        var pillarHeight = 0;
        var totalArea = 0;
        var area = 0;
        for (var h : height) {
            if (h >= pillarHeight) {
                totalArea += area;
                area = 0;
                pillarHeight = h;
            } else {
                area += pillarHeight - h;
            }
        }
        pillarHeight = 0;
        area = 0;
        for (var i = height.length - 1; i >= 0; i--) {
            var h = height[i];
            // Note that we use > instead of >= here, to prevent sums up same pillar height area
            if (h > pillarHeight) {
                totalArea += area;
                area = 0;
                pillarHeight = h;
            } else {
                area += pillarHeight - h;
            }
        }
        return totalArea;
    }

    /**
     * Two pointer solution.
     * <p>
     * Tracking both sides of max height, since we only care about the bottleneck (the height that is shorter).
     * The trapped size should be {@code min(maxHead, maxTail) - current height}.
     */
    public int trapV2(int[] height) {
        var head = 0;
        var tail = height.length - 1;
        var maxHead = 0;
        var maxTail = 0;
        var area = 0;
        while (head < tail) {
            maxHead = Math.max(height[head], maxHead);
            maxTail = Math.max(height[tail], maxTail);
            if (maxHead < maxTail) {
                area += Math.max(maxHead - height[head], 0);
                head++;
            } else {
                area += Math.max(maxTail - height[tail], 0);
                tail--;
            }
        }
        return area;
    }

    public int trapV3(int[] height) {
        var head = 0;
        var tail = height.length - 1;
        var maxHead = height[head];
        var maxTail = height[tail];
        var area = 0;
        while (head < tail) {
            if (maxHead < maxTail) {
                head++;
                maxHead = Math.max(height[head], maxHead);
                area += maxHead - height[head]; // this always >= 0
            } else {
                tail--;
                maxTail = Math.max(height[tail], maxTail);
                area += maxTail - height[tail];
            }
        }
        return area;
    }

}