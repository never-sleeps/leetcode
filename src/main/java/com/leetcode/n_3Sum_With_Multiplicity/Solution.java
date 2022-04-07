package com.leetcode.n_3Sum_With_Multiplicity;

import java.util.Arrays;

/**
 * 923. 3Sum With Multiplicity
 * https://leetcode.com/problems/3sum-with-multiplicity/
 *
 * Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.
 *
 * As the answer can be very large, return it modulo 109 + 7.
 *
 *
 * Example 1:
 * Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
 * Output: 20
 * Explanation:
 * Enumerating by the values (arr[i], arr[j], arr[k]):
 * (1, 2, 5) occurs 8 times;
 * (1, 3, 4) occurs 8 times;
 * (2, 2, 4) occurs 2 times;
 * (2, 3, 3) occurs 2 times.
 *
 * Example 2:
 * Input: arr = [1,1,2,2,2,2], target = 5
 * Output: 12
 * Explanation:
 * arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
 * We choose one 1 from [1,1] in 2 ways,
 * and two 2s from [2,2,2,2] in 6 ways.
 *
 *
 * Constraints:
 * 3 <= arr.length <= 3000
 * 0 <= arr[i] <= 100
 * 0 <= target <= 300
 */
public class Solution {
    public int threeSumMulti(int[] arr, int target) {
        if (null == arr || arr.length < 3) return 0;

        Arrays.sort(arr);
        final int M = 1000000007;
        int result = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            int nextIndex = i + 1;
            int lastIndex = arr.length - 1;

            int t = target - arr[i];

            while (nextIndex < lastIndex) {
                if (arr[nextIndex] + arr[lastIndex] < t) {
                    nextIndex++;
                } else if (arr[nextIndex] + arr[lastIndex] > t) {
                    lastIndex--;
                } else if (arr[nextIndex] != arr[lastIndex]) {
                    int left = 1;
                    int right = 1;
                    while (nextIndex < lastIndex - 1 && arr[nextIndex] == arr[nextIndex + 1]) {
                        nextIndex++;
                        left++;
                    }
                    while (nextIndex + 1 < lastIndex && arr[lastIndex] == arr[lastIndex - 1]) {
                        lastIndex--;
                        right++;
                    }
                    result += left * right;
                    result %= M;

                    if (nextIndex + 1 == lastIndex) {
                        break;
                    } else {
                        nextIndex++;
                        lastIndex--;
                    }
                } else {
                    result += (lastIndex - nextIndex) * (lastIndex - nextIndex + 1) / 2;
                    result %= M;
                    break;
                }
            }
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        var result = new Solution().threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8);
        assert result == 20;

        var result2 = new Solution().threeSumMulti(new int[]{1, 1, 2, 2, 2, 2}, 5);
        assert result2 == 12;
    }
}