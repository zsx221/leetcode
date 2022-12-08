package xhd.practice.GettingStarted;

import lombok.val;

import java.util.HashSet;

/**
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列
 * 请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 *
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * 你所设计的解决方案必须只使用常量级的额外空间。
 */
public class Solution167 {
    public static void main(String[] args) {
        int[]nums={5,25,75};
        int[] twoSum = twoSum(nums,100);
        for (int i : twoSum) {
            System.out.println(i);
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
        int i=1,j=2;//快慢指针
        int []rsult=new int[2];
        HashSet<Integer> set=new HashSet<>();
        while (i<numbers.length&&i<j){
            if (numbers[i-1]+numbers[j-1]==target)
                break;
            j++;
            if (j>numbers.length) {//这个保证j在遍历完数组之后能跳出，重新来一遍
                i++;
                j = i + 1;
            }
        }
        rsult[0]=i;
        rsult[1]=j;
        return rsult;
    }
}
