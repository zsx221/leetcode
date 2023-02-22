package xhd.practice.leetcode.二叉树;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class offer128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0,0}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        nums = Arrays.stream(nums).sorted().toArray();

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int sum = 1;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] - nums[j - 1] == 0)
                    continue;
                if (nums[j] - nums[j - 1] == 1) {
                    sum++;
                }
                max = Math.max(max, sum);
                if (nums[j] - nums[j - 1] != 1)
                    break;
            }
        }
        return max;
    }
}
