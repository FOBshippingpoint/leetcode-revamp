package com.github.fobshippingpoint.s0347topkfrequentelements;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

class Solution {

    /**
     * v1: ordinary bucket sort
     */
    public int[] topKFrequentV1(int[] nums, int k) {
        var freqCount = new HashMap<Integer, Integer>();

        for (var num : nums) {
            freqCount.put(num, freqCount.getOrDefault(num, -1) + 1);
        }

        var bucket = new List[nums.length];
        for (var num : freqCount.keySet()) {
            var freq = freqCount.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<Integer>();
            }
            bucket[freq].add(num);
        }

        var result = new LinkedList<Integer>();
        var j = 0;
        for (var i = bucket.length - 1; i >= 0 && k > 0; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * v2: Use array as everything
     * <p>
     * Not even new one Object
     */
    public int[] topKFrequentV2(int[] nums, int k) {
        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        var freqMap = new int[max - min + 1];
        for (int num : nums) {
            freqMap[num - min]++;
        }

        var freqFreq = new int[nums.length + 1];
        for (int freq : freqMap) {
            if (freq > 0) {
                freqFreq[freq]++;
            }
        }

        var targetFreq = nums.length;
        var currentCount = 0;
        while (true) {
            currentCount += freqFreq[targetFreq];
            if (currentCount >= k) {
                break;
            }
            targetFreq--;
        }

        var result = new int[k];
        var resultIdx = 0;
        for (int i = 0; i < freqMap.length; i++) {
            if (freqMap[i] >= targetFreq) {
                result[resultIdx++] = i + min; // i + min = original num
                if (resultIdx == k) {
                    break;
                }
            }
        }

        return result;
    }

}
