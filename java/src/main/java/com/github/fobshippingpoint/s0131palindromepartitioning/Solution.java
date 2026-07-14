package com.github.fobshippingpoint.s0131palindromepartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        var result = new ArrayList<List<String>>();
        var part = new ArrayList<String>();
        backtrack(s, result, part, 0);
        return result;
    }

    private void backtrack(String s, List<List<String>> result, List<String> part, int i) {
        if (i == s.length()) {
            result.add(List.copyOf(part));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                part.add(s.substring(i, j + 1));
                backtrack(s, result, part, j + 1);
                part.removeLast();
            }
        }

    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}
