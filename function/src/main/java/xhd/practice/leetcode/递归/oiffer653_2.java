package xhd.practice.leetcode.递归;

import java.util.Arrays;

public class oiffer653_2 {
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length==0)
            return null;
        int index = maxNode(nums);
        TreeNode root=new TreeNode(nums[index]);
        root.left=index==0? null:constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,index-1));
        root.right=index== nums.length-2?null:constructMaximumBinaryTree(Arrays.copyOfRange(nums,index+1,nums.length-1));
        return  root;
    }
    static   int maxNode(int[] nums){
        int max = nums[0];
        int index = 0;
        for (int i = 1; i <= nums.length-1; i++) {   //注意每次都在子树所在区间搜索
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

        public static void main(String[] args) {
        int[] nums= {3, 2, 1};
        TreeNode treeNode = constructMaximumBinaryTree(nums);

    }
    static class  TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
