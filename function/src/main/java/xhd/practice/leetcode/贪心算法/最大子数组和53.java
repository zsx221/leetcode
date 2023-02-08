package xhd.practice.leetcode.贪心算法;
/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6
 */
public class 最大子数组和53 {
    public static int maxSubArray(int[] nums) {
        int result=-10*10*10*10;
        int count=0;
        for (int i=0;i<nums.length;i++){
            count+=nums[i];
            if (count>result)
                result=count;
            if (count<0)
                count=0;
        }
        return result;
    }

//    private static void backTracking(int[] nums, int startIndex) {
//        int sum = path.stream().reduce(0, (a, b) -> a + b);
//        result.add(sum);
//        if (startIndex>=nums.length)
//            return;
//        for (int i=startIndex;i<nums.length;i++){
//            path.add(nums[i]);
//            backTracking(nums,i+1);
//            path.removeLast();
//        }
//    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
