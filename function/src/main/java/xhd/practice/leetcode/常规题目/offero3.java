package xhd.practice.leetcode.常规题目;

import java.util.HashSet;
import java.util.Set;

public class offero3 {
    //找出数组中重复的数字。
    /*
    * 输入：
        [2, 3, 1, 0, 2, 5, 3]
        输出：2 或 3
    * */
    public int findRepeatNumber(int[] nums) {//使用set内容不重复解决，但是时间复杂度比较高，O^2
        Set<Integer> set=new HashSet<>(nums.length);
        int i=0;
        int result=0;
        while (i<nums.length){
            if (set.contains(nums[i]))
            {
                result= nums[i];
                break;
            }
            else {
                set.add(nums[i]);
            }
            i++;
        }
        return result;
    }
}
