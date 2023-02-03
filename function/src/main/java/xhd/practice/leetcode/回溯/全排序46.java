package xhd.practice.leetcode.回溯;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class 全排序46 {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        permute(new int[]{1, 1, 2});
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        backTracking(nums);
        return result;
    }

    static void backTracking(int[] candidates) {
        if (path.size() == candidates.length) {
            List<Integer> list = path.stream().sorted().collect(Collectors.toList());
            Integer[] array = list.toArray(new Integer[candidates.length]);
            if (Arrays.equals(Arrays.stream(array).mapToInt(Integer::valueOf).toArray(), Arrays.stream(candidates).sorted().toArray())) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            path.add(candidates[i]);
            backTracking(candidates);
            path.removeLast();
        }
    }
}
