package xhd.practice.leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class 全排列47_2 {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        backTracking(nums, used);
        return result;
    }

    static void backTracking(int[] candidates, boolean[] used) {
        if (path.size() == candidates.length) {
            List<Integer> list = path.stream().sorted().collect(Collectors.toList());
            Integer[] array = list.toArray(new Integer[candidates.length]);
            if (Arrays.equals(Arrays.stream(array).mapToInt(Integer::valueOf).toArray(), Arrays.stream(candidates).sorted().toArray()) && !result.contains(path)) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (used[i] == false) {
                used[i]=true;
                path.add(candidates[i]);
                backTracking(candidates, used);
                path.removeLast();
                used[i]=false;
            }
        }
    }
}
