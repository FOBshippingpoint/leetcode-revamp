package com.github.fobshippingpoint.s0003longestsubstringwithoutrepeatingcharacters;

import java.util.HashSet;

public class Solution {

    public int lengthOfLongestSubstringV1(String s) {
        var head = 0;
        var tail = 0;
        var longest = 0;
        var set = new HashSet<Character>(s.length());

        while (tail < s.length()) {
            if (!set.add(s.charAt(tail))) {
                longest = Math.max(longest, set.size());
                head++;
                tail = head;
                set.clear();
            } else {
                tail++;
            }
        }
        longest = Math.max(longest, set.size());
        return longest;
    }

    public int lengthOfLongestSubstringV2(String s) {
        var head = 0;
        var longest = 0;
        var set = new HashSet<Character>(s.length());

        for (var tailChar : s.toCharArray()) {
            while (set.contains(tailChar)) {
                set.remove(s.charAt(head));
                head++;
            }
            set.add(tailChar);
            longest = Math.max(longest, set.size());
        }
        return longest;
    }
}
