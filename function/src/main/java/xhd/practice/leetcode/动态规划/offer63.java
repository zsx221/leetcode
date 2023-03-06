package xhd.practice.leetcode.动态规划;

/**
 * @author xhd
 * @date 2023/3/6
 */

public class offer63 {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{1, 0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                break;
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                System.out.println("m=" + (i + 1) + " n=" + (j + 1) + "有" + dp[i][j] + "条路径");
            }
        return dp[m - 1][n - 1];
    }
}
