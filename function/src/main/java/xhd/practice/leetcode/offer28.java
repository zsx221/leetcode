package xhd.practice.leetcode;

public class offer28 {//没找到临界点
    public boolean isSymmetric(TreeNode root) {
        if (root==null||root.left.val==root.right.val)
            return false;
        return isSymmetric(root.left) && isSymmetric(root.right);
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
