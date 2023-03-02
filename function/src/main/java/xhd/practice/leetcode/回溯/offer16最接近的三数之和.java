package xhd.practice.leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class offer16最接近的三数之和 {
    static int result;
    static int min = Integer.MAX_VALUE;
    static LinkedList<Integer> path = new LinkedList<>();

    public static int threeSumClosest(int[] nums, int target) {
//        backTracking(nums, target, 0);
        int res = nums[0] + nums[1] + nums[2];
        nums=Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - res)) res = sum;
                if (sum < target) left++;
                else if (sum > target) right--;
                else return res;
            }
        }
        return res;
    }//Math.abs()表示绝对值

    private static void backTracking(int[] nums, int target, int startIndex) {
        if (path.size() >= 3)//割韭菜
        {
            int sum = path.stream().reduce(0, (a, b) -> a + b);
            int value = Math.abs(sum - target);
            if (value < min) {
                min = value;
                result = sum;
            }
            return;
        }
        for (int i=startIndex;i<nums.length;i++){
            path.add(nums[i]);
            backTracking(nums,target,i+1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0,0,0},1));
    }
}
