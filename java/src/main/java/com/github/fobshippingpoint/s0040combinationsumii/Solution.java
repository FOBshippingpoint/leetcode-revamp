package com.github.fobshippingpoint.s0040combinationsumii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        var curr = new ArrayList<Integer>();
        Arrays.sort(candidates);

        dfs(result, 0, curr, 0, candidates, target);
        return result;
    }

    public void dfs(List<List<Integer>> result, int i, List<Integer> curr, int total, int[] candidates, int target) {
        if (total == target) {
            result.add(List.copyOf(curr));
            return;
        }
        if (total > target || i == candidates.length) {
            return;
        }

        curr.add(candidates[i]);
        dfs(result, i + 1, curr, total + candidates[i], candidates, target);
        curr.removeLast();

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        dfs(result, i + 1, curr, total, candidates, target);
    }

}
