package com.leetcode.Next_Permutation;

import java.util.Arrays;

/**
 * 31. Next Permutation
 * https://leetcode.com/problems/next-permutation/
 *
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 *
 * For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 *
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 *
 * The replacement must be in place and use only constant extra memory.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 *
 * Example 3:
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 *
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        // высчитываем индекс предпоследнего элемента массива
        int i = nums.length - 2;

        // находим индекс элемента, на котором будет прерываться восходящая от конца последовательность:
        // в массиве 1, 5, 8, 4, 7, 6, 5, 3, 1 это будет индекс элемента 4, то есть после прохождения цикла i = 3
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1; // высчитываем индекс последнего элемента массива

            // находим индекс элемента, который будет больше найденного элемента,
            // прерывающего восходящую последовательнось от конца
            while (nums[j] <= nums[i]) {
                j--;
            }

            // меняем местами элементы с индексом i и j. полчается:
            // 1, 5, 8, [4], 7, 6, [5], 3, 1 -> 1, 5, 8, [5], 7, 6, [4], 3, 1
            swap(nums, i, j);
        }

        // переворачиваем исходную восходящую от конца последовательность:
        // 1, 5, 8, 5, [ 7, 6, 4, 3, 1 ] -> 1, 5, 8, 5, [ 1, 3, 4, 6, 7]
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class Main {
    public static void main(String[] args) {
        var nums0 = new int[]{1, 5, 8, 4, 7, 6, 5, 3, 1};
        new Solution().nextPermutation(nums0);
        assert Arrays.equals(nums0, new int[]{1, 5, 1});

        var nums1 = new int[]{1, 2, 3};
        new Solution().nextPermutation(nums1);
        assert Arrays.equals(nums1, new int[]{1, 3, 2});

        var nums2 = new int[]{3, 2, 1};
        new Solution().nextPermutation(nums2);
        assert Arrays.equals(nums2, new int[]{1, 2, 3});

        var nums3 = new int[]{1, 1, 5};
        new Solution().nextPermutation(nums3);
        assert Arrays.equals(nums3, new int[]{1, 5, 1});
    }
}