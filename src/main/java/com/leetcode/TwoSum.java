package com.leetcode;

import java.util.*;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            var value = target - nums[i];
            if (map.containsKey(value)) {
                return new int[]{map.get(value), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}

class Main {
    public static void main(String[] args) {
        var result1 = new TwoSum().twoSum(new int[] {2, 7, 11, 15}, 9);
        assert(Arrays.equals(result1, new int[]{0, 1}));

        var result2 = new TwoSum().twoSum(new int[] {3, 2, 4}, 6);
        assert(Arrays.equals(result2, new int[]{1, 2}));

        var result3 = new TwoSum().twoSum(new int[] {3, 3}, 6);
        assert(Arrays.equals(result3, new int[]{0, 1}));
    }
}
