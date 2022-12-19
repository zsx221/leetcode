package xhd.practice.Hot100;
//两数之和

import lombok.val;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 示例：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        nums = twoSum(nums, 7);
        for (int num : nums) {
            System.out.print(num);
        }
        System.out.println();
    }

//    public static int[] twoSum(int[] nums, int target) {//暴力解决
//        int n = nums.length;
//        for (int i = 0; i < n; ++i) {
//            for (int j = i + 1; j < n; ++j) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[0];
//    }
    public static int[] twoSum(int[] nums, int target) {//优化，改为找target-nums[i]
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i]))
                return new int[]{map.get(target-nums[i]),i};
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
