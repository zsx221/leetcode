package xhd.practice.leetcode.动态规划;

/**
 * 分割等和子集
 *
 * @author xhd
 * @date 2023/3/8
 */

import java.util.Arrays;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 思路 01背包问题
 */
public class offer416 {
    public static void main(String[] args) {
        canPartition(new int[]{1, 5, 11, 5});
    }

    public static boolean canPartition(int[] nums) {

        if (Arrays.stream(nums).sum() % 2 != 0) return false;
        int target = Arrays.stream(nums).sum() / 2;//背包的容量
        int[] dp = new int[target + 1];
        //遍历物品
        for (int i = 0; i < nums.length; i++)
            for (int j = target; j >= nums[i]; j--)//遍历背包
            {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        return dp[target] == target;
    }
}
