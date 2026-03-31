package com.github.fobshippingpoint.s0347topkfrequentelements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    public static Stream<Arguments> provider() {
        return Stream.of(
                // Arguments.of("Should be duplicates since the element 1 occurs at the indices 0 and 3.",
                //         new int[]{1, 2, 3, 1}, true),
                // Arguments.of("Should not be duplicates since All elements are distinct.",
                //         new int[]{1, 2, 3, 4}, false),
                // Arguments.of("Should be duplicates since The element 1 occurs at the indices 0 and 1.",
                //         new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("provider")
    void test__solution__() {

    }

}
// 
// Example 1:
//
// Input: nums = [1,1,1,2,2,3], k = 2
//
// Output: [1,2]
//
// Example 2:
//
// Input: nums = [1], k = 1
//
// Output: [1]
//
// Example 3:
//
// Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
//
// Output: [1,2]
// import java.util.HashMap;
// import java.util.List;
// import java.util.LinkedList;
//
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         var freqCount = new HashMap<Integer, Integer>();
//
//         for (var num : nums) {
//             freqCount.put(num, freqCount.getOrDefault(num, -1) + 1);
//         }
//
//         var bucket = new List[nums.length];
//         for (var num : freqCount.keySet()) {
//             var freq = freqCount.get(num);
//
//             if (bucket[freq] == null) {
//                 bucket[freq] = new LinkedList<Integer>();
//             }
//             bucket[freq].add(num);
//         }
//
//         var result = new LinkedList<Integer>();
//         var j = 0;
//         for (var i = bucket.length - 1; i >= 0 && k > 0; i--) {
//             if (bucket[i] != null) {
//                 result.addAll(bucket[i]);
//                 k -= bucket[i].size();
//             }
//         }
//
//         return result.stream().mapToInt(Integer::intValue).toArray();
//     }
// }
