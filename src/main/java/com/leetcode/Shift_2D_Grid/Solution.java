package com.leetcode.Shift_2D_Grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1260. Shift 2D Grid
 * https://leetcode.com/problems/shift-2d-grid/
 *
 * Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
 *
 * In one shift operation:
 *
 * Element at grid[i][j] moves to grid[i][j + 1].
 * Element at grid[i][n - 1] moves to grid[i + 1][0].
 * Element at grid[m - 1][n - 1] moves to grid[0][0].
 * Return the 2D grid after applying shift operation k times.
 *
 * Example 1:
 *  1  2  3        9  1  2
 *  4  5  6   ->   3  4  5
 *  7  8  9        6  7  8
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * Output: [[9,1,2],[3,4,5],[6,7,8]]
 *
 * Example 2:
 * Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 *
 * Example 3:
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * Output: [[1,2,3],[4,5,6],[7,8,9]]
 */
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        //move k times first
        while (k > 0) {
            int pre = grid[grid.length - 1][grid[0].length - 1];
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    //swap with the previous element
                    int temp = grid[row][col];
                    grid[row][col] = pre;
                    pre = temp;
                }
            }
            k--;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            result.add(Arrays.stream(row).boxed().toList());
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        var result = new Solution().shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);
        assert result != null;
        assert result.size() == 3;
        assert result.get(0).get(0) == 9;
        assert result.get(0).get(1) == 1;
        assert result.get(0).get(2) == 2;
        assert result.get(1).get(0) == 3;
        assert result.get(1).get(1) == 4;
        assert result.get(1).get(2) == 5;
        assert result.get(2).get(0) == 6;
        assert result.get(2).get(1) == 7;
        assert result.get(2).get(2) == 8;
    }
}
