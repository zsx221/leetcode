package xhd.practice.leetcode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class 组合总和40_2 {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 5, 2, 1, 2};
        combinationSum2(candidates, 5);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        brackTracking(candidates, target, 0);
        return result;
    }

    static void brackTracking(int[] candidates, int target, int index) {
        //收集条件
        int sum = path.stream().reduce(0, (a, b) -> a + b);
        if (sum == target) {
            List<Integer> list = path.stream().sorted().collect(Collectors.toList());
//            for (Integer i : list) {
//                System.out.print(i+" ");
//            }
//            System.out.println();
            if (!result.contains(list))
                result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target)
                continue;
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue; // 剪枝：i > start是关键，此时candidates[i]和candidates[i - 1]在同一层中
            }
            path.add(candidates[i]);
            brackTracking(candidates, target, i + 1);
            path.removeLast();
        }
    }
}
