package xhd.practice.leetcode.常规题目;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class offer34 {
    public static void main(String[] args) {
        int[] result = searchRange(new int[]{1}, 1);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int[] result = new int[]{-1, -1};
        boolean flag1 = false, flag2 = false;
        while (i <= j) {
            if (!flag1)
                if (nums[i] == target) {
                    result[0] = i;
                    flag1 = true;
                } else
                    i++;
            if (!flag2)
                if (nums[j] == target) {
                    result[1] = j;
                    flag2 = true;
                } else
                    j--;
            if (flag1 && flag2) {
                break;
            }
        }
        return result;
    }

}
