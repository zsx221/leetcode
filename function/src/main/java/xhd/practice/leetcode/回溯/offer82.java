package xhd.practice.leetcode.回溯;

import java.util.*;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 */
public class offer82 {
    static List<List<Integer>> result = new ArrayList<>();
    static  LinkedList<Integer> path =new LinkedList<>();
    static HashSet<List<Integer>> set=new HashSet<>();
    public static void main(String[] args) {
        combinationSum2(new int[]{10,1,2,7,6,1,5},8);
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
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        backTracking(candidates, target,0);
        for (List<Integer> list : result) {
            Collections.sort(list);
        }
        for (List<Integer> list : result) {
            if (!set.contains(list))
                set.add(list);
        }
        result.removeAll(result);
        result.addAll(set);
        return result;
    }

    private static void backTracking(int[] candidates, int target,int startIndex) {
        //终止条件,收集条件
        int sum = path.stream().reduce(0, (a, b) -> a + b);
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (path.size()==candidates.length)
            return;
        for (int i = startIndex; i < candidates.length; i++) {
            if(sum + candidates[i]> target) return;
            if(i > startIndex && candidates[i] == candidates[i - 1]) {
                continue; // 剪枝：i > start是关键，此时candidates[i]和candidates[i - 1]在同一层中
            }
            path.add(candidates[i]);
            backTracking(candidates,target,i+1);
            path.removeLast();
        }
    }
}
