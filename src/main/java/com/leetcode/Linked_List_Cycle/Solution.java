package com.leetcode.Linked_List_Cycle;

import java.util.HashSet;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        HashSet<ListNode> set = new HashSet<>();
        for(ListNode node = head; node != null; node = node.next) {
            if (!set.add(node)) {
                return true;
            }
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Main {
    public static void main(String[] args) {
        ListNode node00 = new ListNode(3);
        ListNode node01 = new ListNode(2);
        ListNode node02 = new ListNode(0);
        ListNode node03 = new ListNode(-4);
        node00.next = node01;
        node01.next = node02;
        node02.next = node03;
        node03.next = node01;
        var result1 = new Solution().hasCycle(node00);
        assert result1;
    }
}