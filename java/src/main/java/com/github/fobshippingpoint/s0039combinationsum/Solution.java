package com.github.fobshippingpoint.s0039combinationsum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        var curr = new ArrayList<Integer>();
        dfs(result, 0, curr, 0, candidates, target);
        return result;
    }

    private void dfs(List<List<Integer>> result, int i, List<Integer> curr, int total, int[] candidates, int target) {
        if (total == target) {
            result.add(List.copyOf(curr));
            return;
        }
        if (i >= candidates.length || total > target) {
            return;
        }

        curr.add(candidates[i]);
        dfs(result, i, curr, total + candidates[i], candidates, target);
        curr.removeLast();
        dfs(result, i + 1, curr, total, candidates, target);
    }

}
