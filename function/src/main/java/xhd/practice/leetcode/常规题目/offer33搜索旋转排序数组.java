package xhd.practice.leetcode.常规题目;

public class offer33搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int result = 0;
        for (int num : nums) {
            if (num == target)
                return result;
            result++;
        }
        return -1;
    }
}
