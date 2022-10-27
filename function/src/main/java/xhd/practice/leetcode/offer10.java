package xhd.practice.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 */
public class offer10 {
//    public int fib(int n) {
//        if (n==0||n==1){
//            return n;
//        }
//        if (n==2)
//            return 1;
//        return (fib(n-1)%1000000007+fib(n-2)%1000000007)%1000000007;
//    }
    public int fib(int n) {
    if (n==0||n==1){
        return n;
    }
    int a[]=new int[n+1];
    int result=0;
    a[0]=0;
    a[1]=1;
    for (int i=2;i<=n;i++){

        a[i]=a[i-1]+a[i-2];
        if (a[i]>=1000000007)
            a[i]=a[i]-1000000007;
    }
    return a[n]%1000000007;
    }
    @Test
    public void  test(){
        System.out.println(fib(7));
    }
}
