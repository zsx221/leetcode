package xhd.practice.GettingStarted;

import lombok.val;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution189 {
    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static void rotate(int[] nums, int k) {
        Queue<Integer> queue=new LinkedList<>();
        for (int t=nums.length-1;t>=0;t--){
            queue.add(nums[t]);
        }
        int i=0;
        while (i<k){
                int value = queue.remove();
                queue.add(value);
            i++;
        }
        for (int t=nums.length-1;t>=0;t--){
            nums[t]=queue.remove();
        }
    }

}
