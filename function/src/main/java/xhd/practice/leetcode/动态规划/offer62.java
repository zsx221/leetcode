package xhd.practice.leetcode.动态规划;

/**
 * @author xhd
 * @date 2023/3/3
 */

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * 输入：m = 3, n = 7
 * 输出：28
 */
public class offer62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));

    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                System.out.println("m=" + (i + 1) + " n=" + (j + 1) + "有" + dp[i][j] + "条路径");
            }
        return dp[m - 1][n - 1];
    }
}
