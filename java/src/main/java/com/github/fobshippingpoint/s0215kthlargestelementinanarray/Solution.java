package com.github.fobshippingpoint.s0215kthlargestelementinanarray;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public int findKthLargestV1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargestV2(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>();
        for (var num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.remove();
    }

    public int findKthLargestV3(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int q) {
        var pivot = nums[right];
        var pointer = left;

        for (var i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                // Keep nums[left..pointer) less than or equal to the pivot.
                var tmp = nums[pointer];
                nums[pointer] = nums[i];
                nums[i] = tmp;
                pointer++;
            }
        }

        // [left .. pivot .. right]
        var tmp = nums[pointer];
        nums[pointer] = nums[right];
        nums[right] = tmp;

        if (pointer < q) {
            // The target index is in the larger partition (right).
            return quickSelect(nums, pointer + 1, right, q);
        } else if (pointer > q) {
            // The target index is in the smaller partition (left).
            return quickSelect(nums, left, pointer - 1, q);
        } else {
            return nums[pointer];
        }
    }

}
