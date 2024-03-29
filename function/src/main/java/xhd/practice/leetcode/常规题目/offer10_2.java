package xhd.practice.leetcode.常规题目;

import org.junit.Test;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 */
public class offer10_2 {
    public int numWays(int n) {
        if (n==0)
            return 1;
        if (n==1||n==2)
            return n;
        int a[]=new int[n+1];
        a[0]=1;
        a[1]=1;
        for (int i=2;i<=n;i++){

            a[i]=a[i-1]+a[i-2];
            if (a[i]>=1000000007)
                a[i]=a[i]-1000000007;
        }
        return a[n];
    }
    @Test
    public void  test(){
        System.out.println(numWays(7));
    }
}
