package com.leetcode.Game_of_Life;

/**
 * 289. Game of Life
 * https://leetcode.com/problems/game-of-life/
 *
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 *
 *
 * Example 1:
 * 0  1  0      0  0  0
 * 0  0  1  ->  1  0  1
 * 1  1  1      0  1  1
 * 0  0  0      0  1  0
 *
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 *
 * Example 2:
 * 1  1  ->  1  1
 * 1  0      1  1
 *
 * Input: board = [[1,1],[1,0]]
 * Output: [[1,1],[1,1]]
 */
public class Solution {
    /**
     * board[i][j]==0  died before
     * board[i][j]==1  lived before
     * board[i][j]==2  living cell death
     * board[i][j]==3  dead cell resurrection
     */
    public int[][] gameOfLife(int[][] board) {
        int[][] dir = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int outerArrLength = board.length;
        int innerArrLength = board[0].length;

        for (int i = 0; i < outerArrLength; i++) {
            for (int j = 0; j < innerArrLength; j++) {
                int live = 0;
                //8 directions to search
                for (int[] d : dir) {
                    //Array cannot out of bounds
                    if (d[0] + i < 0 || d[0] + i >= outerArrLength || d[1] + j < 0 || d[1] + j >= innerArrLength) {
                        continue;
                    }
                    //Count the number of living
                    if (board[d[0] + i][d[1] + j] == 1 || board[d[0] + i][d[1] + j] == 2) {
                        live++;
                    }
                }
                //4，dead cell resurrection
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 3;
                }
                // 1,3，living cell death
                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                }
                //2, living cells are still alive
            }
        }

        for (int i = 0; i < outerArrLength; i++) {
            for (int j = 0; j < innerArrLength; j++) {
                board[i][j] %= 2;
            }
        }
        return board;
    }
}

class Main {
    public static void main(String[] args) {
        var result = new Solution().gameOfLife(new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        });
        assert result[0][0] == 0;
        assert result[0][1] == 0;
        assert result[0][2] == 0;

        assert result[1][0] == 1;
        assert result[1][1] == 0;
        assert result[1][2] == 1;

        assert result[2][0] == 0;
        assert result[2][1] == 1;
        assert result[2][2] == 1;

        assert result[3][0] == 0;
        assert result[3][1] == 1;
        assert result[3][2] == 0;
    }
}
