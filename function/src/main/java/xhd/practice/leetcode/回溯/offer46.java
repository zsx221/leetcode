package xhd.practice.leetcode.回溯;

import lombok.val;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class offer46 {
    static List<List<Integer>> list2 = new ArrayList<>();
    static public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return list2;
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];//用来剪枝或者去重
        dfs(nums, path, used);
        return list2;
    }
    public static void main(String[] args) {
        List<List<Integer>> lists = permute(new int[]{1, 2, 3});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
    static void dfs(int[] nums, List<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            list2.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true)//剪枝
                continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, path, used);
            path.remove(path.size() - 1);//每次得到一个排列时，清空path数组
            used[i] = false;//设置
        }
    }
}
