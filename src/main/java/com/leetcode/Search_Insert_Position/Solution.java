package com.leetcode.Search_Insert_Position;

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        var left = 0;
        var right = nums.length - 1;

        while(left <= right) {
            var middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else {
                if (target > nums[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return left;
    }
}

class Main {
    public static void main(String[] args) {
        var result0 = new Solution().searchInsert(new int[]{1,3,5,6}, 5);
        assert result0 == 2;

        var result1 = new Solution().searchInsert(new int[]{1,3,5,6}, 2);
        assert result1 == 1;

        var result2 = new Solution().searchInsert(new int[]{1,3,5,6}, 7);
        assert result2 == 4;
    }
}
