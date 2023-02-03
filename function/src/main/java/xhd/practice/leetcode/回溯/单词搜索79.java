package xhd.practice.leetcode.回溯;

import java.util.Arrays;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 */
public class 单词搜索79 {
    public boolean exist(char[][] board, String word) {
        boolean used[][]=new boolean[board.length][board[0].length];
        Arrays.fill(used,false);
        return backTracking(0,0,used,board,word);
    }

    public boolean backTracking(int i, int j, boolean[][] used, char[][] board, String word) {
        return true;
    }
}
