package xhd.practice.递归;

import lombok.val;

import java.util.Arrays;

public class oiffer653 {
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length-1);
    }
    static TreeNode  build(int[] nums, int first, int end){
        if (first>end)
            return null;
        int index = maxNode(nums,first,end);
        TreeNode root=new TreeNode(nums[index]);
        root.left=build(nums,first,index-1);
        root.right=build(nums,index+1,end);
        return  root;
    }
    static int maxNode(int[] nums,int first ,int end) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = first; i <= end; i++) {   //注意每次都在子树所在区间搜索
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
