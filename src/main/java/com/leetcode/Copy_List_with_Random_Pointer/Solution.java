package com.leetcode.Copy_List_with_Random_Pointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 *
 * Example 1:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Example 2:
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 *
 * Example 3:
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 */
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);

        map.put(head, newHead);

        Node tmp = newHead;

        for (Node n = head; n != null; n = n.next) {
            Node randomNode = n.random;
            Node nextNode = n.next;

            // create & update random pointer (if needed)
            if (randomNode != null) {
                // create new random node (if needed)
                if (!map.containsKey(randomNode)) {
                    map.put(randomNode, new Node(randomNode.val));
                }
                // point to next random node
                tmp.random = map.get(randomNode);
            }

            // create & update next pointer (if needed)
            if (nextNode != null) {
                // create new next node (if needed)
                if (!map.containsKey(nextNode)) {
                    map.put(nextNode, new Node(nextNode.val));
                }
                // point to next node
                tmp.next = map.get(nextNode);
            }
            tmp = tmp.next;
        }

        return newHead;
    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Main {
    public static void main(String[] args) {
        // [[7,null],[13,0],[11,4],[10,2],[1,0]]
        //     0        1     2      3      4
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n1.random = n0;
        n2.random = n4;
        n3.random = n2;
        n4.random = n0;

        Node result = new Solution().copyRandomList(n0);
        assert result != null;
        assert result.val == n0.val;
        assert result.next.val == n0.next.val;
        assert result.next.next.val == n0.next.next.val;
        assert result.next.next.next.val == n0.next.next.next.val;
    }
}
