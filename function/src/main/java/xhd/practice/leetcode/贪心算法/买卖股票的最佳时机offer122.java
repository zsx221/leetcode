package xhd.practice.leetcode.贪心算法;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 */
public class 买卖股票的最佳时机offer122 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
    public static int maxProfit(int[] prices) {
        int startIndex=0,endIndex=0,result = 0;
        for (int i=1;i<prices.length;i++){
            if (prices[i]-prices[i-1]<0)
            {
                continue;
            }
            startIndex=i-1;
            endIndex=i;
            result=result+prices[endIndex]-prices[startIndex];
        }
        return result;
    }
}
