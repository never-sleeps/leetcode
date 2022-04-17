package com.leetcode.Increasing_Order_Search_Tree;

/**
 * 897. Increasing Order Search Tree
 * https://leetcode.com/problems/increasing-order-search-tree/
 *
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.
 *
 * Example 1:
 *                     5                     ->     1
 *           3                   6                     2
 *       2      4                    8                    3
 *    1                            7   9                     4
 *                                                              5
 *                                                                 6
 *                                                                    7
 *                                                                       8
 *                                                                          9
 * Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 */
public class Solution {
    private TreeNode current;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode answer = new TreeNode(0);
        current = answer;
        inorder(root);
        return answer.right;
    }

    public void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            node.left = null;
            current.right = node;
            current = node;
            inorder(node.right);
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
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        n5.left = n3;
        n3.left = n2;
        n2.left = n1;
        n3.right = n4;

        n5.right = n6;
        n6.right = n8;
        n8.left = n7;
        n8.right = n9;

        var result = new Solution().increasingBST(n5);
        assert result != null;
        assert result.val == 1;
        assert result.right.val == 2;
        assert result.left == null;
        assert result.right.right.val == 3;
        assert result.right.left == null;
        assert result.right.right.right.val == 4;
        assert result.right.right.left == null;
        assert result.right.right.right.right.val == 5;
        assert result.right.right.right.left == null;
        assert result.right.right.right.right.right.val == 6;
        assert result.right.right.right.right.left == null;
        assert result.right.right.right.right.right.right.val == 7;
        assert result.right.right.right.right.right.left == null;
        assert result.right.right.right.right.right.right.right.val == 8;
        assert result.right.right.right.right.right.right.left == null;
        assert result.right.right.right.right.right.right.right.right.val == 9;
        assert result.right.right.right.right.right.right.right.left == null;
    }
}

