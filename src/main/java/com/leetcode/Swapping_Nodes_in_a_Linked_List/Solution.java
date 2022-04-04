package com.leetcode.Swapping_Nodes_in_a_Linked_List;

/**
 * 1721. Swapping Nodes in a Linked List
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 *
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 *
 * Example 2:
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 *
 *
 * Constraints:
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
 *
 */
public class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null) return null;

        ListNode leftElement = null;
        ListNode rightElement = null;

        int size = calculateSize(head);
        if (size < 2) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (int i = 0; i < size + 1; i++) {
            if (i == k) {
                leftElement = dummy;
            }
            if (i == size - k + 1) {
                rightElement = dummy;
            }
            dummy = dummy.next;
        }

        var tmp = leftElement.val;
        leftElement.val = rightElement.val;;
        rightElement.val = tmp;

        return head;
    }

    private int calculateSize(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int size = 0;
        while(dummy.next != null) {
            size++;
            dummy = dummy.next;
        }
        return size;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Main {
    public static void main(String[] args) {
        // head = [1,2,3,4,5], k = 2
        var n0 = new ListNode(1);
        var n1 = new ListNode(2);
        var n2 = new ListNode(3);
        var n3 = new ListNode(4);
        var n4 = new ListNode(5);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        var result = new Solution().swapNodes(n0, 2);
        assert result != null;
        assert result.val == 1;
        assert result.next.val == 4;
        assert result.next.next.val == 3;
        assert result.next.next.next.val == 2;
        assert result.next.next.next.next.val == 5;

        var n01 = new ListNode(1);
        var n02 = new ListNode(2);
        n01.next = n02;
        var result1 = new Solution().swapNodes(n01, 1);
        assert result1 != null;
        assert result1.val == 2;
        assert result1.next.val == 1;
    }
}