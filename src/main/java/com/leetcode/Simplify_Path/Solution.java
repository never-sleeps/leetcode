package com.leetcode.Simplify_Path;

import java.util.Stack;

/**
 * 71. Simplify Path
 * https://leetcode.com/problems/simplify-path/
 *
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 *
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 *
 * The canonical path should have the following format:
 *
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 *
 * Example 1:
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 *
 * Example 2:
 * Input: path = "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 *
 * Example 3:
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 */
public class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String p : paths) {
            if (p == null || p.length() == 0 || p.equals(".")) {
                continue;
            } else if (p.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(p);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.empty()) {
            stringBuilder.insert(0, "/" + stack.pop());
        }

        return (stringBuilder.length() == 0) ? "/" : stringBuilder.toString();
    }
}

class Main {
    public static void main(String[] args) {
        var result1 = new Solution().simplifyPath("/home/");
        assert result1.equals("/home");

        var result2 = new Solution().simplifyPath("/../");
        assert result2.equals("/");

        var result3 = new Solution().simplifyPath("/home//foo/");
        assert result3.equals("/home/foo");

        var result4 = new Solution().simplifyPath("/home/../foo/");
        assert result4.equals("/foo");
    }
}
