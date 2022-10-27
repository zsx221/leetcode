package xhd.practice.leetcode.递归;

public class offer111 {
    public int minDepth(TreeNode root) {
        if (root==null)
            return 0;
        if(root.left == null && root.right == null) return 1;
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        if(root.left == null || root.right == null) return left + right + 1;
        return Math.min(left,right)+1;
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
