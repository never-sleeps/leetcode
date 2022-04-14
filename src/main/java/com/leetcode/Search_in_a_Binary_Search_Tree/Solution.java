package com.leetcode.Search_in_a_Binary_Search_Tree;

/**
 * 700. Search in a Binary Search Tree
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 *
 * Example 1:
 *                   4
 *               2       7
 *            1    3
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 *
 * Example 2:
 *                   4
 *               2       7
 *            1    3
 * Input: root = [4,2,7,1,3], val = 5
 * Output: []
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode dummy = root;

        while (true) {
            if (dummy.val == val) {
                return dummy;
            }
            if (val < dummy.val) {
                if (dummy.left == null) {
                    return null;
                }
                dummy = dummy.left;
            } else {
                if (dummy.right == null) {
                    return null;
                }
                dummy = dummy.right;
            }
        }
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Main {
    public static void main(String[] args) {
        var n0 = new TreeNode(4);
        var n1 = new TreeNode(2);
        var n2 = new TreeNode(7);
        var n3 = new TreeNode(1);
        var n4 = new TreeNode(3);
        n0.right = n2;
        n0.left = n1;
        n1.right = n4;
        n1.left = n3;
        var result = new Solution().searchBST(n0, 2);
        assert result.val == 2;
        assert result.left.val == 1;
        assert result.right.val == 3;
    }
}
