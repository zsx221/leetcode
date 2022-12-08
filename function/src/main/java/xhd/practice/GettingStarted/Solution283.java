package xhd.practice.GettingStarted;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class Solution283 {
    public static void main(String[] args) {
        int[] nums= new int[]{0,0,-32191,-21331,0,0,0,-18879};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }
    public static void moveZeroes(int[] nums) {
        //计算数组中0的数量,然后找到0，直接整体前移，把0，放在最后
        int sum=0,i=0;
        for (int num : nums) {
            if (num==0)
                sum++;
        }
        int j=0;
        while (i++<sum){
          for ( ;j<nums.length;j++)
              if (nums[j]==0)
                  break;
          turnLeft(nums,j);
        }
    }

    private static void turnLeft(int[] nums, int j) {
        int now=nums[j];
        for (int i=j;i<nums.length-1;i++)
                nums[i] = nums[i + 1];
        nums[nums.length-1]=now;
    }
}
