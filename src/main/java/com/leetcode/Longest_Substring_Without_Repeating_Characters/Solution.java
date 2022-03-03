package com.leetcode.Longest_Substring_Without_Repeating_Characters;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 *
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 0;
        // seenCharacters - список индексов символов в строке. каждому коду ASCI символу соответствует индекс, на котором он встречается в строке
        int[] seenCharacters = new int[256]; // s consists of English letters, digits, symbols and spaces.
        for (int i = 0, j = 0; j < s.length(); j++) {
            i = Math.max(i, seenCharacters[s.charAt(j)]);
            count = Math.max(count, j - i + 1);
            seenCharacters[s.charAt(j)] = j + 1;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        var result = new Solution().lengthOfLongestSubstring("abcabcbb");
        assert result == 3;

        var result2 = new Solution().lengthOfLongestSubstring("bbbbb");
        assert result2 == 1;

        var result3 = new Solution().lengthOfLongestSubstring("pwwkew");
        assert result3 == 3;
    }
}
