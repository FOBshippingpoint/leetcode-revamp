package com.github.fobshippingpoint.s0127wordladder;

import java.util.HashSet;
import java.util.List;

public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        var wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        var beginSet = new HashSet<String>();
        var endSet = new HashSet<String>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        var level = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                var temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            var nextLevel = new HashSet<String>();

            for (var word : beginSet) {
                var chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    var originalChar = chars[i];

                    // Building variants (inserting wildcard * from start to end)
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) {
                            continue;
                        }

                        chars[i] = c;
                        var target = new String(chars);
                        if (endSet.contains(target)) {
                            return level + 1;
                        }
                        if (wordSet.remove(target)) {
                            nextLevel.add(target);
                        }
                    }

                    chars[i] = originalChar;
                }
            }

            beginSet = nextLevel;
            level++;
        }

        return 0;
    }

}
