package xhd.practice.leetcode.回溯;

import java.util.*;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 */
public class offer1014最佳观光组合 {

    static  LinkedList<Integer> path =new LinkedList<>();
    static  LinkedList<Integer> result =new LinkedList<>();
    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{1,2}));
//        for (List<Integer> list : result) {
//            if (!set.contains(list))
//                set.add(list);
//        }
//        for (List<Integer> list : set) {
//            for (Integer integer : list) {
//                System.out.print(integer);
//            }
//            System.out.println();
//        }

    }
    public static int maxScoreSightseeingPair(int[] values) {
        backTracking(values,0);
        return Collections.max(result);
    }

    private static void backTracking(int[] candidates,int startIndex) {
        //终止条件,收集条件
        if (path.size()==2){
            result.add(candidates[path.get(0)]+candidates[path.get(1)]+path.get(0)-path.get(1));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(i);
            backTracking(candidates,i+1);
            path.removeLast();
        }
    }
}
