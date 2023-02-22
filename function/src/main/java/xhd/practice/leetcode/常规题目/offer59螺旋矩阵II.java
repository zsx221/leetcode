package xhd.practice.leetcode.常规题目;


/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 */
public class offer59螺旋矩阵II {
    public static void main(String[] args) {
        generateMatrix(3);
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0, j = 0, cur = 2;
        res[0][0] = 1;
        while (cur <= n * n) {
            while (j < n - 1 && res[i][j + 1] == 0) res[i][++j] = cur++; // 右
            while (i < n - 1 && res[i + 1][j] == 0) res[++i][j] = cur++; // 下
            while (j > 0 && res[i][j - 1] == 0) res[i][--j] = cur++; // 左
            while (i > 0 && res[i - 1][j] == 0) res[--i][j] = cur++; // 上
        }
        return res;
    }
}
