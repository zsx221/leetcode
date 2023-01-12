package xhd.practice.leetcode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 */
public class 组合总和4_377 {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{4,2,1}, 32));
    }

    public static int combinationSum4(int[] nums, int target) {
        backTracking(nums, target);
        return result.size();
    }

    private static void backTracking(int[] candidates, int target) {
        //终止条件,收集条件
        int sum = path.stream().reduce(0, (a, b) -> a + b);
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (sum + candidates[i] > target)
                continue;
//            if (sum + candidates[i]== target) {
//                path.add(candidates[i]);
//                result.add(new ArrayList<>(path));
//                return;
//            }
            path.add(candidates[i]);
            backTracking(candidates, target);
            path.removeLast();
        }
    }
}
