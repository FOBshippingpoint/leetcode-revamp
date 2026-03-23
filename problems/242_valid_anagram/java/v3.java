import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
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

