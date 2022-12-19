package xhd.practice.GettingStarted;

import lombok.val;

import java.util.Stack;

/**
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：
 * 如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 *
 * 返回合并后的二叉树。
 */
public class Solution617 {
    //解题思路：遍历两棵树所有节点，使用深度优先算法
    public static void main(String[] args) {
//        TreeNode root1 = {1,3,2,5}, root2 = [2,1,3,null,4,null,7]
//        TreeNode root1=new TreeNode(1);
//        root1.left=new TreeNode(3);
//        root1.right=new TreeNode(2);
//        root1.left.left=new TreeNode(5);
//        TreeNode root2=new TreeNode(2);
//         root2.left=new TreeNode(1);
//         root2.right=new TreeNode(3);
//         root2.left.right=new TreeNode(4);
//         root2.right.right=new TreeNode(7);
        TreeNode root1=new TreeNode();
        TreeNode root2=new TreeNode(2);
        TreeNode treeNode = mergeTrees(root1, root2);

        System.out.println();
    }
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null&&root2==null)
            return null;
        TreeNode head=new TreeNode((root1==null? 0:root1.val)+ (root2 == null ? 0 : root2.val));
        Stack<TreeNode[]> stack=new Stack<>();
        stack.add(new TreeNode[]{root1,root2,head});
        if (root1==null)
           return root2;
        else if (root2==null)
            return root1;
        while (!stack.isEmpty()){
            TreeNode[] array = stack.pop();
            TreeNode node1=array[0], node2=array[1],now=array[2];

              if (!(node1.left==null&&node2.left==null))//如果左子树不同时为空,那就走左子树
            {
                if (node1.left==null)
                    now.left=node2.left;
                else if (node2.left==null)
                    now.left=node1.left;
                else {
                    now.left=new TreeNode((node1.left==null? 0:node1.left.val)+ (node2.left == null ? 0 : node2.left.val));
                    stack.add(new TreeNode[]{node1.left, node2.left, now.left});
                }
            }
            if (!(node1.right==null&&node2.right==null))//如果左子树不同时为空,那就走左子树
            {

                if (node1.right==null)
                    now.right=node2.right;
                else if (node2.right==null)
                    now.right=node1.right;
                else {
                    now.right=new TreeNode((node1.right==null? 0:node1.right.val)+ (node2.right == null ? 0 : node2.right.val));
                    stack.add(new TreeNode[]{node1.right,node2.right,now.right});
                }
            }
        }
        return head;
    }
   static class TreeNode {
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
