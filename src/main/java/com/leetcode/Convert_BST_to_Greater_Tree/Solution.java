package com.leetcode.Convert_BST_to_Greater_Tree;

/**
 * 538. Convert BST to Greater Tree
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 *
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
 *
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1 (picture in attachment):
 * Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 */
public class Solution {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
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
        TreeNode n0 = new TreeNode(4);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(8);

        n0.left = n1;
        n1.left = n3;
        n1.right = n4;
        n4.right = n7;

        n0.right = n2;
        n2.left = n5;
        n2.right = n6;
        n6.right = n8;

        var result = new Solution().convertBST(n0);
        assert result != null;
        assert result.val == 30;
        assert result.left.val == 36;
        assert result.left.left.val == 36;
        assert result.left.right.val == 35;
        assert result.left.right.right.val == 33;

        assert result.right.val == 21;
        assert result.right.left.val == 26;
        assert result.right.right.val == 15;
        assert result.right.right.right.val == 8;
    }
}
