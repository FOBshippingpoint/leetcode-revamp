import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        var set = new HashSet<Integer>();
        for (var n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }
        return false;
    }
}
