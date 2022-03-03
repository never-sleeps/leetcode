package com.leetcode.Valid_Parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 *
 * https://leetcode.com/problems/valid-parentheses/
 */
public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false; // нечетное число символов в строке -> строка невалидна

        Map<Character, Character> brackets = new HashMap<>(3);
        brackets.put('}', '{');
        brackets.put(']', '[');
        brackets.put(')', '(');

        var stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (!brackets.containsKey(c)) {
                stack.push(c); // найденный символ - открывающая скобка, сохраняем её в стек
            } else {
                if (stack.isEmpty()) {
                    return false; // найденный символ - закрывающая скобка, при этом стек пуст -> строка невалидна
                }

                if (stack.pop() != brackets.get(c)) {
                    return false; // верхний элемент стека - не открывающая скобка, найденный символ - закрывающая скобка -> строка невалидна
                }
            }
        }
        return stack.isEmpty(); // стек после обработки строки пуст -> строка валидна
    }
}

class Main {
    public static void main(String[] args) {
        var result1 = new Solution().isValid("()");
        assert(result1);

        var result2 = new Solution().isValid("()[]{}");
        assert(result2);

        var result3 = new Solution().isValid("(]");
        assert(!result3);

        var result4 = new Solution().isValid("({[]})");
        assert(result4);
    }
}
