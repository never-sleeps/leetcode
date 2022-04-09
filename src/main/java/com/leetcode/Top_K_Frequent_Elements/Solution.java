package com.leetcode.Top_K_Frequent_Elements;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
//  Runtime: 43 ms, faster than 5.16% of Java online submissions for Top K Frequent Elements.
//  Memory Usage: 50.4 MB, less than 60.79% of Java online submissions for Top K Frequent Elements.
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> nToCountMap = new HashMap<>();
        for(int n : nums) {
            int count = nToCountMap.getOrDefault(n, 0) + 1;
            nToCountMap.put(n, count);
        }

        return nToCountMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(k)
                .mapToInt(n -> n)
                .toArray();
    }
}

class Main {
    public static void main(String[] args) {
        var result1 = new Solution().topKFrequent(new int[] {1,1,1,2,2,3}, 2);
        assert result1.length == 2;
        assert result1[0] == 1;
        assert result1[1] == 2;
    }
}
