package xhd.practice.leetcode.回溯;

import lombok.val;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 */
public class offer216组合综合3 {
    static List<List<Integer>> result = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1);
        return result;
    }

    private static void backTracking(int k, int n, int startIndex) {
        int sum = path.stream().reduce(0, (a, b) -> a + b);
        if (path.size() == k) {//收集
            if (sum == n)
                result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            if (i + sum > n)//剪枝
                return;
            path.add(i);
            backTracking(k, n, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        combinationSum3(4, 1);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
