package com.github.fobshippingpoint.s0151reversewordsinastring;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public String reverseWordsV1(String s) {
        var words = new ArrayList<String>();
        Collections.addAll(words, s.split("\\s+"));
        return String.join(" ", words.reversed()).trim();
    }

    public String reverseWordsV2(String s) {
        var sb = new StringBuilder();
        var tail = s.length() - 1;

        while (tail >= 0) {
            // Skip trailing white space until reach the word (end of the word)
            while (tail >= 0 && s.charAt(tail) == ' ') {
                tail--;
            }
            if (tail < 0) {
                break;
            }

            var end = tail + 1;
            // Skip until reach the whitespace (start of the word)
            while (tail >= 0 && s.charAt(tail) != ' ') {
                tail--;
            }
            var start = tail + 1;

            if (!sb.isEmpty()) {
                sb.append(' ');
            }
            sb.append(s, start, end);
        }
        return sb.toString();
    }

}
