package xhd.practice.leetcode.常规题目;

public class offer27 {
    //思路
    /**
     * 1、获取root
     * 2、获取左子树，获取右子树
     * 3、把root的左子树和右子树反转
     */
    /**
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null||(root.left==null&&root.right==null))
            return root;
        TreeNode left=mirrorTree(root.left);
        TreeNode right=mirrorTree(root.right);
        root.right=left;
        root.left=right;
        return  root;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
