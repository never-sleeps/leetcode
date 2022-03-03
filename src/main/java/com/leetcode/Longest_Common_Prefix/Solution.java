package com.leetcode.Longest_Common_Prefix;

/**
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 *
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String result = "";
        for(int i = 0; i <= strs[0].length(); i++) {
            boolean areEquals = true;
            String valueForCheck = strs[0].substring(0, i);
            for(String e : strs) {
                if (!e.startsWith(valueForCheck)) {
                    areEquals = false;
                    break;
                }
            }
            if (!areEquals) {
                result = valueForCheck.substring(0, valueForCheck.length() - 1);
                break;
            }
            result = valueForCheck;
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        var result0 = new Solution().longestCommonPrefix(new String[] {"a"});
        assert "a".equals(result0);

        var result1 = new Solution().longestCommonPrefix(new String[] {"flower","flow","flight"});
        assert "fl".equals(result1);

        var result2 = new Solution().longestCommonPrefix(new String[] {"dog","racecar","car"});
        assert "".equals(result2);
    }
}
