package com.github.fobshippingpoint.s0090subsetsii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        var result = new ArrayList<List<Integer>>();
        backtrack(result, new ArrayList<>(), 0, nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> subset, int i, int[] nums) {
        if (i == nums.length) {
            result.add(List.copyOf(subset));
            return;
        }

        // All subsets that include nums[i]
        subset.add(nums[i]);
        backtrack(result, subset, i + 1, nums);
        subset.removeLast();

        // All subsets that don't include nums[i]
        // Jump across the nums[i] to the next number
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(result, subset, i + 1, nums);
    }

}
