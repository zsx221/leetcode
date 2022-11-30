package xhd.practice.NC.递归;
//一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
//
//        数据范围：1 \leq n \leq 401≤n≤40
//        要求：时间复杂度：O(n)O(n) ，空间复杂度： O(1)O(1)
public class NC68 {
    public int jumpFloor(int target) {
        //Sum(n)=
        //第一步确定边界条件
        if (target==1||target==2)
            return target;
        //确定一次递归干的事情
        int result=jumpFloor(target-1)+jumpFloor(target-2);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new NC68().jumpFloor(3));
    }
}
