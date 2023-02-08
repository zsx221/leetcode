package xhd.practice.leetcode.常规题目;

import lombok.val;

public class offer12_1 {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i=0;i<board.length;i++)
            for (int j=0;j<board[0].length;j++)
            {
                if (bfs(board, chars,i, j, 0))
                    return true;
            }
        return false;
    }

    private boolean bfs(char[][] board,  char[] word,int i, int j, int index) {
        //判断临界点
        if (i>=board.length||j>=board[0].length||i<0||j<0||board[i][j]!=word[index]){
            return false;
        }
        //查找完了，就退出
        if (index== word.length-1)
            return true;
        //设置temp
        char temp=board[i][j];
        board[i][j]='.';
        boolean res=bfs(board,word,i-1,j,index+1)||bfs(board,word,i+1,j,index+1)||
        bfs(board,word,i,j+1,index+1)||bfs(board,word,i,j-1,index+1);
        board[i][j]=temp;
        return res;
    }
}
