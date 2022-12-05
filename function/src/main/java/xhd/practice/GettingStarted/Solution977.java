package xhd.practice.GettingStarted;

public class Solution977 {
    public static void main(String[] args) {
        int[] nums = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 10 };
        int[] newNums = sortedSquares(nums);
        for (int x : newNums) {
            System.out.println(x);
        }
    }
    public static int[] sortedSquares(int[] nums) {
        if (nums.length==0||nums.length==1)
            return nums;
        int i=1;
        nums[0]=nums[0]*nums[0];
        while(i<nums.length)
        {
            nums[i]=nums[i]*nums[i];
            if(nums[i-1]<0&&nums[i]>0) {
                break;
            }
            i++;
        }
        //此处可使用归并算法
            return mergeSort(nums,0,nums.length-1);
    }
    public static int[] mergeSort(int[] nums, int l, int h) {//归并算法，先分后合
        if (l == h)
            return new int[] { nums[l] };
        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(nums, l, mid); //左有序数组
        int[] rightArr = mergeSort(nums, mid + 1, h); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组
        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {//满足左右数组尚未合并完
            newNum[m++] = leftArr[i] <= rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length)   //满足右数组已经合并完了
            newNum[m++] = leftArr[i++];
        while (j < rightArr.length)  //满足左数组已经合并完了
            newNum[m++] = rightArr[j++];
        return newNum;
    }
}
