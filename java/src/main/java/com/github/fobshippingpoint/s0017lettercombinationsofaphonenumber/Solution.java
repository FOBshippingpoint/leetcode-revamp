package com.github.fobshippingpoint.s0017lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {

    private final Map<Character, char[]> digitToChars = Map.of(
            '2', "abc".toCharArray(),
            '3', "def".toCharArray(),
            '4', "ghi".toCharArray(),
            '5', "jkl".toCharArray(),
            '6', "mno".toCharArray(),
            '7', "pqrs".toCharArray(),
            '8', "tuv".toCharArray(),
            '9', "wxyz".toCharArray()
    );

    public List<String> letterCombinations(String digits) {
        var result = new ArrayList<String>();
        if (digits.isEmpty()) {
            return result;
        }
        backtrack(digits, result, 0, "");
        return result;
    }

    private void backtrack(String digits, List<String> result, int i, String s) {
        if (s.length() == digits.length()) {
            result.add(s);
            return;
        }

        for (var ch : digitToChars.get(digits.charAt(i))) {
            backtrack(digits, result, i + 1, s + ch);
        }
    }

}
