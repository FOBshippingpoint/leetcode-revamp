import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        // Different length means they are not the same
        if (s.length() != t.length()) {
            return false;
        }
        var sMap = new HashMap<Integer, Integer>();
        var tMap = new HashMap<Integer, Integer>();
        for (int c : s.toCharArray()) {
            sMap.put(c, sMap.computeIfAbsent(c, k -> 0) + 1);
        }
        for (int c : t.toCharArray()) {
            if (sMap.get(c) == null) {
                return false;
            }
            tMap.put(c, tMap.computeIfAbsent(c, k -> 0) + 1);
        }

        return sMap.equals(tMap);
    }
}
