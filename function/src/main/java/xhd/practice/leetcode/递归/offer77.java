package xhd.practice.leetcode.递归;

import lombok.val;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * '给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 */
public class offer77 {

    public static void main(String[] args) {
        combine(4, 2);
//        for (List<Integer> list : result) {
//            for (Integer integer : list) {
//                System.out.print(integer);
//            }
//            System.out.println();
//        }
    }
    static List<List<Integer>> result=new ArrayList<>();
    static LinkedList<Integer> path= new LinkedList<>();

    public static List<List<Integer>> combine(int n, int k) {
        backstracking(n,k,1);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
        return result;
    }

    /**
     *    递归三部曲
     *    1、确定递归的参数和返回值
     *    2、确定递归终止条件
     *    3、单层递归的逻辑，和回溯
     */
    static void backstracking(int n,int k,int startValue){//确定递归的参数和返回值,使用startValue来确定起点
        if (path.size()==k)//确定终止条件，等到说收集够了k个值，就终止
        {
            result.add(new ArrayList<>(path));
            return;
        }
        //单层递归的逻辑
        for (int i=startValue;i<=n;i++){
            path.add(i);
            backstracking(n,k,i+1);//继续递归下一层
            path.removeLast();//回溯
        }
    }
}
