package xhd.practice.leetcode.贪心算法;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 */
public class offer55跳跃游戏2 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,0,1,4}));
    }

    public static int canJump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int cover = 0;
        int result = 0;
        for (int i = 0; i <= cover; i++) {
            if (cover < i + nums[i]) {
                result++;
                cover = i + nums[i];
            }
            if (cover >= nums.length - 1) {
                cover = Math.min(cover,nums.length-1);
            }
        }
        return result;
    }
}
