package com.leetcode;

/**
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * For example, 121 is a palindrome while 123 is not.
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {
    public boolean isPalindrome(final int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int invertedX = 0;
        int copyOfX = x;
        while (copyOfX != 0) {
            invertedX = invertedX * 10 + copyOfX % 10;
            copyOfX = copyOfX / 10;
        }
        return invertedX == x;
    }
}
class Main9 {
    public static void main(String[] args) {
        var result1 = new PalindromeNumber().isPalindrome(121);
        assert result1;

        var result2 = new PalindromeNumber().isPalindrome(-121);
        assert !result2;
    }
}
