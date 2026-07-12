package com.github.fobshippingpoint.s0078subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> subset, int[] nums, int i) {
        if (i >= nums.length) {
            result.add(List.copyOf(subset));
            return;
        }

        // To include current number
        subset.add(nums[i]);
        dfs(result, subset, nums, i+1);
        // Not to include current number
        subset.removeLast();
        dfs(result, subset, nums, i+1);
    }

}
