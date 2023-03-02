package xhd.practice.leetcode.回溯;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组
 * [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */
public class offer18 {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        nums = Arrays.stream(nums).sorted().toArray();
        backTracking(nums, target, 0);
        return result.stream().distinct().collect(Collectors.toList());
    }

    private static void backTracking(int[] nums, int target, int startIndex) {
        int sum = path.stream().reduce(0, Integer::sum);
        if (path.size() >= 4) {
            if (sum == target)
                result.add(new ArrayList<>(path.stream().sorted().collect(Collectors.toList())));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums, target, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
