package xhd.practice.leetcode;

import lombok.val;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个m*n 二维字符网格board 和一个字符串单词word 。
 * 如果word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 */

/**
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 */
public class offer12 {
//    public boolean exist(char[][] board, String word) {
//     //这里可以使用BFS算法执行，
//        //思想：使用队列作为辅助
//        //将临边能访问的点放入队列，再进行判断，然后出队
//        //如果能找到出口，就继续遍历这个点的下一个能触及的点
//        Queue<Character> queue=new LinkedList<>();
//        char[] chars = word.toCharArray();
//        int m=board.length ,n=board[0].length;
//        int i=0,j=0,k=1;
//        boolean flag=false;
//        queue.add(board[i][j]);
//        for (;i<m;i++)//找word中的第一个字符
//            for (;j<n;j++)
//                if (board[i][j]==chars[0]) {
//                    flag=true;
//                    break;
//                }
//        if (flag){//找到了第一个字符
//            while (i<m&&j<n&&k<chars.length){
//                if (j-1>=0&&board[i][j-1]==chars[k]) {
//                    j=j-1;
//                    queue.add(board[i][j - 1]);
//                }
//                if (j+1<n&&board[i][j+1]==chars[k]) {
//                    j=j+1;
//                    queue.add(board[i][j + 1]);
//                }
//                if (i-1>0&&board[i-1][j]==chars[k]) {
//                    i=i-1;
//                    queue.add(board[i - 1][j]);
//                }
//                if (i+1<m&&board[i+1][j]==chars[k])
//                    i=i+1;
//                    queue.add(board[i+1][j]);
//            }
//
//
//        }
//        return false;
//}

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //从[i,j]这个坐标开始查找
                if (dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
        //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index])
            return false;
        //如果word的每个字符都查找完了，直接返回true
        if (index == word.length - 1)
            return true;
        //把当前坐标的值保存下来，为了在最后复原
        char tmp = board[i][j];
        //然后修改当前坐标的值
        board[i][j] = '.';
        //走递归，沿着当前坐标的上下左右4个方向查找
        boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
        //递归之后再把当前的坐标复原
        board[i][j] = tmp;
        return res;
    }
}
