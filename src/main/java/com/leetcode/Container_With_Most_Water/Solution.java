package com.leetcode.Container_With_Most_Water;

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 *
 *
 * Constraints:
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 */
public class Solution {
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int max = 0;
        while(leftIndex < rightIndex){
            int width = rightIndex - leftIndex;
            int minHeight = Math.min(height[leftIndex], height[rightIndex]);
            int area = minHeight * width;
            max = Math.max(max, area);

            if(height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else if(height[leftIndex] > height[rightIndex]) {
                rightIndex--;
            } else {
                leftIndex++;
                rightIndex--;
            }
        }
        return max;
    }
}

class Main {
    public static void main(String[] args) {
        var result1 = new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        assert result1 == 49;
    }
}
