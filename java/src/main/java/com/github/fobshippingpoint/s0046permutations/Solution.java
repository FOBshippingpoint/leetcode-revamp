package com.github.fobshippingpoint.s0046permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> permuteV1(int[] nums) {
        if (nums.length == 0) {
            return List.of(List.of());
        }

        var perms = permuteV1(Arrays.copyOfRange(nums, 1, nums.length));
        var result = new ArrayList<List<Integer>>();
        for (var perm : perms) {
            for (int i = 0; i <= perm.size(); i++) {
                var p = new ArrayList<>(perm);
                p.add(i, nums[0]);
                result.add(p);
            }
        }
        return result;
    }

    public List<List<Integer>> permuteV2(int[] nums) {
        List<List<Integer>> perms = List.of(List.of());
        for (var num : nums) {
            var newPerms = new ArrayList<List<Integer>>();
            for (var perm : perms) {
                for (int i = 0; i<= perm.size(); i++) {
                    var p = new ArrayList<>(perm);
                    p.add(i, num);
                    newPerms.add(p);
                }
            }
            perms = newPerms;
        }
        return perms;
    }

}
