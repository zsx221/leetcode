package xhd.practice.leetcode.动态规划;

/**
 * @author xhd
 * @date 2023/3/6
 */

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 */
public class offer343 {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++)
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(Math.max(dp[i - j] * j, j * (i - j)), dp[i]);
            }
        return  dp[n];
    }
//    public static int integerBreak(int n) {
//        if (n <= 3) {
//            return n - 1;
//        }
//        int quotient = n / 3;
//        if (n % 3 == 0)
//            return (int) Math.pow(3, quotient);
//        else if (n % 3 == 1)
//            return (int) (Math.pow(3, quotient - 1) * 4);
//
//        return (int) Math.pow(3, quotient) * 2;
//    }
}
