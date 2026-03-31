package com.github.fobshippingpoint.s0271encodeanddecodestrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public String encodeV1(List<String> strs) {
        // We need a special flag for completely empty input (not empty string)
        // Because both [""] and [] will encode to ""
        if (strs.isEmpty()) return "無";
        return String.join("切", strs);
    }

    public List<String> decodeV1(String str) {
        if (str.equals("無")) return new ArrayList<>();
        // split limit -1 will not drop empty strings
        return Arrays.asList(str.split("切", -1));
    }

    public String encodeV2(List<String> strs) {
        var sb = new StringBuilder();
        for (var s : strs) {
            sb.append(s.length()).append(";").append(s);
        }
        return sb.toString();
    }

    public List<String> decodeV2(String str) {
        var start = 0;
        var ret = new ArrayList<String>();
        for (var i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ';') {
                var len = Integer.parseUnsignedInt(str, start, i, 10);
                start = i + 1;
                ret.add(str.substring(start, start + len));
                start += len;
                i = start;
            }
        }
        return ret;
    }

    public String encodeV3(List<String> strs) {
        var sb = new StringBuilder();
        for (var s : strs) {
            // Pad left with zeros to 3-digits. E.g., 3 => 003, 20 => 020
            // This would work because the max string size is 200, less than 4-digits
            sb.append(String.format("%03d", s.length())).append(s);
        }
        return sb.toString();
    }

    public List<String> decodeV3(String str) {
        var start = 0;
        var ret = new ArrayList<String>();
        while (start != str.length()) {
            var len = Integer.parseUnsignedInt(str, start, start + 3, 10);
            start += 3;
            ret.add(str.substring(start, start + len));
            start += len;
        }
        return ret;
    }

}
