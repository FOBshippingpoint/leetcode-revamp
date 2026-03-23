import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        var ss = s.toCharArray();
        var tt = t.toCharArray();
        Arrays.sort(ss);

        return Arrays.equals(ss, tt);
    }
}

void main() {
  var sol = new Solution();
  assert sol.isAnagram("anagram", "nagaram") == true : "s=\"anagram\", t=\"nagaram\" is anagram";
  assert sol.isAnagram("rat", "car") == false : "s=\"rat\", t=\"car\" is not anagram";
  System.out.println("ok");
}
