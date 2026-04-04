package com.github.fobshippingpoint.s0125validpalindrome;

public class Solution {

    /**
     * Simply remove non-alphanumeric chars and check if each chars are the same from head and tail.
     *
     * @see <a href="https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/regex/Pattern.html#sum">Regex Pattern</a>
     */
    public boolean isPalindromeV1(String s) {
        var normalized = s.replaceAll("[^\\p{Alnum}]", "").toLowerCase();
        for (var i = 0; i < normalized.length() / 2; i++) {
            if (normalized.charAt(i) != normalized.charAt(normalized.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeV2(String s) {
        var head = 0;
        var tail = s.length() - 1;
        while (head < tail) {
            var headChar = s.charAt(head);
            var tailChar = s.charAt(tail);
            if (!Character.isLetterOrDigit(headChar)) {
                head++;
                continue;
            }
            if (!Character.isLetterOrDigit(tailChar)) {
                tail--;
                continue;
            }
            if (Character.toLowerCase(headChar) != Character.toLowerCase(tailChar)) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
}
