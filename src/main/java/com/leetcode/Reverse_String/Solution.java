package com.leetcode.Reverse_String;

/**
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class Solution {
    public void reverseString(char[] s) {
        if (s.length == 1) return;

        int leftIndex = 0;
        int rightIndex = s.length - 1;

        while (leftIndex < rightIndex) {
            char tmp = s[leftIndex];
            s[leftIndex++] = s[rightIndex];
            s[rightIndex--] = tmp;
        }
    }
}

class Main {
    public static void main(String[] args) {
        new Solution().reverseString(new char[]{'h','e','l','l','o'});
    }
}
