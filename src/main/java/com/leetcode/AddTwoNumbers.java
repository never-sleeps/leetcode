package com.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 *
 *
 * https://leetcode.com/problems/add-two-numbers/
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            stringBuilder.append(current.val).append(",");
            current = current.next;
        }
        return "[" + stringBuilder.toString().substring(0, stringBuilder.toString().length()-1) + "]";
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode l1_ = l1, l2_ = l2;
        ListNode current = dummyHead;

        int carry = 0;
        while (l1_ != null || l2_!= null) {
            int x = (l1_ != null) ? l1_.val : 0;
            int y = (l2_ != null) ? l2_.val : 0;
            int digit = carry + x + y;
            current.next = new ListNode(digit % 10);
            carry = digit / 10;
            current = current.next;

            if (l1_ != null) {
                l1_ = l1_.next;
            }
            if (l2_ != null) {
                l2_ = l2_.next;
            }
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

class Main2 {
    public static void main(String[] args) {
        ListNode x = new ListNode(2);
        ListNode y = new ListNode(4);
        ListNode z = new ListNode(3);
        x.next = y;
        y.next = z;
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(6);
        ListNode c = new ListNode(4);
        a.next = b;
        b.next = c;
        var result1 = new AddTwoNumbers().addTwoNumbers(x, a);
        assert result1.toString().equals("[7,0,8]");

        var result2 = new AddTwoNumbers().addTwoNumbers(new ListNode(0), new ListNode(0));
        assert result2.toString().equals("[0]");

        ListNode q11 = new ListNode(9);
        ListNode q12 = new ListNode(9);
        ListNode q13 = new ListNode(9);
        ListNode q14 = new ListNode(9);
        ListNode q15 = new ListNode(9);
        ListNode q16 = new ListNode(9);
        ListNode q17 = new ListNode(9);
        q11.next = q12;
        q12.next = q13;
        q13.next = q14;
        q14.next = q15;
        q15.next = q16;
        q16.next = q17;
        ListNode q21 = new ListNode(9);
        ListNode q22 = new ListNode(9);
        ListNode q23 = new ListNode(9);
        ListNode q24 = new ListNode(9);
        q21.next = q22;
        q22.next = q23;
        q23.next = q24;
        var result3 = new AddTwoNumbers().addTwoNumbers(q11, q21);
        assert result3.toString().equals("[8,9,9,9,0,0,0,1]");
    }
}
