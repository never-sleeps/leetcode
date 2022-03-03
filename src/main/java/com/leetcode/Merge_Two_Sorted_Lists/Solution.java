package com.leetcode.Merge_Two_Sorted_Lists;

/**
 * 21. Merge Two Sorted Lists
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
          ListNode totalList = new ListNode(0);
          ListNode current = totalList;
          while (list1 != null && list2 != null) {
               if (list1.val < list2.val) {
                    current.next = list1;
                    list1 = list1.next;
               } else {
                    current.next = list2;
                    list2 = list2.next;
               }
               current = current.next;
          }
          if (list1 != null) {
               current.next = list1;
          }
          if (list2 != null) {
               current.next = list2;
          }
          return totalList.next;
     }
}

class Main {
     public static void main(String[] args) {
          ListNode l11 = new ListNode(1);
          ListNode l12 = new ListNode(2);
          ListNode l13 = new ListNode(4);
          ListNode l21 = new ListNode(1);
          ListNode l22 = new ListNode(3);
          ListNode l23 = new ListNode(4);
          l11.next = l12;
          l12.next = l13;
          l21.next = l22;
          l22.next = l23;
          var result1 = new Solution().mergeTwoLists(l11, l21);
          assert(result1.val == 1);
          assert(result1.next.val == 1);
          assert(result1.next.next.val == 2);
          assert(result1.next.next.next.val == 3);
          assert(result1.next.next.next.next.val == 4);
          assert(result1.next.next.next.next.next.val == 4);
          assert(result1.next.next.next.next.next.next == null);

          var result2 = new Solution().mergeTwoLists(new ListNode(0).next, new ListNode(0).next);
          assert(result2 == null);

          var result3 = new Solution().mergeTwoLists(new ListNode(0), new ListNode(0).next);
          assert(result3.val == 0);
          assert(result3.next == null);
     }
}
