package com.github.fobshippingpoint.s0242validanagram;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public boolean isAnagramV1(String s, String t) {
        var ss = s.toCharArray();
        var tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);

        return Arrays.equals(ss, tt);
    }

    public boolean isAnagramV2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        var sMap = new HashMap<Integer, Integer>();
        var tMap = new HashMap<Integer, Integer>();
        for (int c : s.toCharArray()) {
            sMap.put(c, sMap.computeIfAbsent(c, _ -> 0) + 1);
        }
        for (int c : t.toCharArray()) {
            if (sMap.get(c) == null) {
                return false;
            }
            tMap.put(c, tMap.computeIfAbsent(c, _ -> 0) + 1);
        }

        return sMap.equals(tMap);
    }

    public boolean isAnagramV3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var charOccurrenceMap = new int['z' + 1];
        for (int c : s.toCharArray()) {
            charOccurrenceMap[c]++;
        }
        for (int c : t.toCharArray()) {
            if (charOccurrenceMap[c] == 0) {
                return false;
            }
            charOccurrenceMap[c]--;
        }

        return true;
    }

}