package com.leetcode.Spiral_Matrix_II;

/**
 * 59. Spiral Matrix II
 * https://leetcode.com/problems/spiral-matrix-ii/
 *
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example 1:
 * 1  2  3
 * 8  9  4
 * 7  6  5
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 * 1 <= n <= 20
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        var grid = new int[n][n];
        var maxIndex = n -1;

        var number = 1;
        var maxNumber = n * n;
        var shift = 0;

        while (number <= maxNumber) {
            var rowShift = 0;
            var columnShift = 0;

            for (int j = shift; j <= maxIndex - shift; j++) {
                grid[shift][j] = number;
                number++;
            }
            rowShift++;

            for(int i = shift + rowShift; i <= maxIndex - shift; i++) {
                grid[i][maxIndex - shift] = number;
                number++;
            }
            columnShift++;

            for (int j = maxIndex - shift - columnShift; j >= shift; j--) {
                grid[maxIndex - shift][j] = number;
                number++;
            }

            for(int i = maxIndex - shift - rowShift; i >= shift + rowShift; i--) {
                grid[i][shift] = number;
                number++;
            }

            shift++;
        }

        return grid;
    }
}

class Main {
    public static void main(String[] args) {
        var result = new Solution().generateMatrix(3);
        assert result[0][0] == 1;
        assert result[0][1] == 2;
        assert result[0][2] == 3;
        assert result[1][2] == 4;
        assert result[2][2] == 5;
        assert result[2][1] == 6;
        assert result[2][0] == 7;
        assert result[1][0] == 8;
        assert result[1][1] == 9;

        print(result);
    }

    private static void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

