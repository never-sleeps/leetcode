package com.leetcode.Kth_Largest_Element_in_a_Stream;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 703. Kth Largest Element in a Stream
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * Design a class to find the kth largest element in a stream.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Implement KthLargest class:
 *
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 * int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 *
 * Example 1:
 *
 * Input
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * Output
 * [null, 4, 5, 5, 8, 8]
 *
 * Explanation
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 */
public class Solution {
    public static void main(String[] args) {
        var kthLargest = new KthLargest(3, new int[] {4, 5, 8, 2});
        var result1 = kthLargest.add(3);
        assert result1 == 4;
        var result2 = kthLargest.add(5);
        assert result2 == 5;
        var result3 = kthLargest.add(10);
        assert result3 == 5;
        var result4 = kthLargest.add(9);
        assert result4 == 8;
        var result5 = kthLargest.add(4);
        assert result5 == 8;
    }
}

class KthLargest {
    private int k;
    private Queue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();
        for (int num: nums) {
            heap.offer(num);
        }
        while (heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
