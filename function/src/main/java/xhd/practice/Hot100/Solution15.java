package xhd.practice.Hot100;

import lombok.val;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 */
public class Solution15 {
    public static void main(String[] args) {
      int[]  nums = {3,0,-2,-1,1,2};
        List<List<Integer>> list = threeSum(nums);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
    //暴力解法
    public static List<List<Integer>> threeSum(int[] nums) {
        int i=0,j=1,k=2;
        int lenth=nums.length;
        List<List<Integer>> list=new ArrayList<>();
        Set<String>set=new HashSet<>();
        while (i<lenth-2){
            if(j==lenth-1) {
                i++;
                j = i + 1;
                k=j+1;
                if (j==lenth-1)
                    continue;
                if (k==lenth)
                    continue;
            }
            if (k==lenth) {
                j++;
                k = j + 1;
                if (k==lenth)
                    continue;
            }

        //开始做逻辑
            if (i != j&&i != k&&j != k){
                if (nums[i] + nums[j] + nums[k] == 0){
                    if (!set.contains(sort(nums[i],nums[j],nums[k]))) {
                        set.add(sort(nums[i],nums[j],nums[k]));
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        list.add(temp);
                    }
                }
            }
            k++;
        }//继续排序
        return list;
    }

    private static String sort(int a, int b, int c) {
        int temp;
        if(a>b) {
            temp = a; a = b;b = temp;
        }
        if(b>c) {
            temp = b;b = c; c = temp;
        }
        if(a>b) {
            temp = a; a = b;b = temp;
        }
        return a+""+b+""+c;
    }
}
