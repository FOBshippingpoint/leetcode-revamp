package com.github.fobshippingpoint.s0238productofarrayexceptself;

public class Solution {

    public int[] productExceptSelfV1(int[] nums) {
        var prefix = new int[nums.length];
        var postfix = new int[nums.length];
        var result = new int[nums.length];

        for (var head = 0; head < nums.length; head++) {
            var tail = nums.length - head - 1;

            if (head == 0) {
                prefix[head] = nums[head];
            } else {
                prefix[head] = nums[head] * prefix[head - 1];
            }

            if (tail == nums.length - 1) {
                postfix[tail] = nums[tail];
            } else {
                postfix[tail] = nums[tail] * postfix[tail + 1];
            }
        }

        for (var i = 0 ; i < nums.length; i++) {
            if (i == 0) {
                result[i] = postfix[i + 1];
            } else if (i == nums.length - 1) {
                result[i] = prefix[i - 1];
            } else {
                result[i] = prefix[i - 1] * postfix[i + 1];
            }
        }
        return result;
    }

    public int[] productExceptSelfV2(int[] nums) {
        var result = new int[nums.length];

        var prefix = 1;
        for (var i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        var postfix = 1;
        for (var j = nums.length - 1; j >= 0; j--) {
            result[j] *= postfix;
            postfix *= nums[j];
        }

        return result;
    }

    public int[] productExceptSelfV3(int[] nums) {
        var result = new int[nums.length];

        var val = 1;
        for (var i = 0; i < nums.length; i++) {
            result[i] = val;
            if (i == nums.length - 1) {
                val = 1;
            } else {
                val *= nums[i];
            }
        }

        for (var j = nums.length - 1; j >= 0; j--) {
            result[j] *= val;
            if (j != 0) val *= nums[j];
        }

        return result;
    }
}
