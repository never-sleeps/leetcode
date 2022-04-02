package com.leetcode.Valid_Palindrome_II;

/**
 * 680. Valid Palindrome II
 * https://leetcode.com/problems/valid-palindrome-ii/
 *
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 * Example 1:
 * Input: s = "aba"
 * Output: true
 *
 * Example 2:
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 *
 * Example 3:
 * Input: s = "abc"
 * Output: false
 *
 * Constraints:
 *
 * 1 <= s.length <= 10 в 5-ой степени
 * s consists of lowercase English letters.
 */
public class Solution {
    public boolean validPalindrome(String s) {
        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        while (leftIndex < rightIndex) {
            if (s.charAt(leftIndex) != s.charAt(rightIndex)) {
                return checkIsPalindrome(s, leftIndex, rightIndex - 1) ||
                        checkIsPalindrome(s, leftIndex + 1, rightIndex);
            }
            leftIndex++;
            rightIndex--;
        }

        return true;
    }

    private boolean checkIsPalindrome(String s, int leftIndex, int rightIndex) {
        while (leftIndex < rightIndex) {
            if (s.charAt(leftIndex) != s.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        var result1 = new Solution().validPalindrome("aba");
        assert result1;

        var result2 = new Solution().validPalindrome("abca");
        assert result2;

        var result3 = new Solution().validPalindrome("abc");
        assert !result3;

        var result4 = new Solution().validPalindrome("abcddba");
        assert result4;
    }
}
