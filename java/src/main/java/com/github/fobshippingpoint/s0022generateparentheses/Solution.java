package com.github.fobshippingpoint.s0022generateparentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        var result = new ArrayList<String>();
        backtrack(n, 0, 0, "", result);
        return result;
    }

    public void backtrack(int n, int openN, int closeN, String parentheses, List<String> result) {
        if (openN == closeN && openN == n) {
            result.add(parentheses);
            return;
        }

        if (openN < n) {
            backtrack(n, openN + 1, closeN, parentheses + "(", result);
        }
        if (closeN < openN) {
            backtrack(n, openN, closeN + 1, parentheses + ")", result);
        }
    }

}
