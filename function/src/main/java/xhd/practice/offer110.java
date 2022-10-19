package xhd.practice;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class offer110 {
    public boolean isBalanced(TreeNode root) {
        if (root==null)
            return false;
        if(maxDepth(root)==0)
            return false;
        return true;
    }
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int righ = maxDepth(root.right);
        if (left-righ>1)
            return 0;
        return Math.max(left,righ)+1;
    }
    class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
