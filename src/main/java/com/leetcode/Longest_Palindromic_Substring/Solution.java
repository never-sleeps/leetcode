package com.leetcode.Longest_Palindromic_Substring;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int start = 0;
        int end = 0;

        // traverse the string left to right - O(n)
        for (int i = 0; i < s.length(); i++) {

            // single character at center (odd number of characters in s) - O(n)
            var length1 = expandFromTo(s, i, i);

            // contiguous characters at center (even number of characters in s) - O(n)
            var length2 = expandFromTo(s, i, i + 1);

            // select the max length for the palindrome
            var maxLength = Math.max(length1, length2);

            // update the start and end characters in the palindrome (if needed)
            if (maxLength > end - start) {
                // update start and end indices in palindrome
                start   = i - (maxLength - 1) / 2;
                end     = i + (maxLength / 2);
            }
        }
        // return longest Palindrome
        return s.substring(start, end + 1);
    }

    private int expandFromTo(String s, int left, int right) {
        if (s == null || left > right) return 0;
        while (
                left >= 0 &&
                right < s.length() &&
                s.charAt(left) == s.charAt(right)
        ) {
            left--;
            right++;
        }
        // return length of palindrome
        return right - left - 1;
    }
}

class Main {
    public static void main(String[] args) {
        var result1 = new Solution().longestPalindrome("babad");
        assert result1.equals("bab") || result1.equals("aba");

        var result2 = new Solution().longestPalindrome("cbbd");
        assert result2.equals("bb");
    }
}
