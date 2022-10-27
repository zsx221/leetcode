package xhd.practice.leetcode.递归;

import xhd.practice.leetcode.TreeNode;

public class offer226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null))
            return root;
        TreeNode right=invertTree(root.left);
        TreeNode left=invertTree(root.right);
        root.left=left;
        root.right=right;
        return root;
    }
}
