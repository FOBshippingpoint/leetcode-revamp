package com.github.fobshippingpoint.s1768mergestringsalternately;

public class Solution {

    public String mergeAlternately(String word1, String word2) {
        var merged = new StringBuilder();
        var len1 = word1.length();
        var len2 = word2.length();
        var minLength = Math.min(len1, len2);
        for (int i = 0; i < minLength; i++) {
            merged.append(word1.charAt(i));
            merged.append(word2.charAt(i));
        }
        var longer = minLength == len1 ? word2 : word1;
        merged.append(longer.substring(minLength));
        return merged.toString();
    }

}
