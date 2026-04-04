package com.github.fobshippingpoint.s0167twosumiiinputarrayissorted;

public class Solution {

    public int[] twoSumV1(int[] numbers, int target) {
        var head = 0;
        var tail = numbers.length - 1;

        while (head < tail) {
            var sum = numbers[head] + numbers[tail];
            if (sum == target) {
                return new int[]{head + 1, tail + 1};
            } else if (sum < target) {
                head++;
            } else {
                tail--;
            }
        }
        return null;
    }

}
