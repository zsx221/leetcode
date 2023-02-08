package xhd.practice.leetcode.常规题目;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断B是否是A的子树
 */
public class offer26树的子结构 {
    //难点1，找到，遍历所有的节点，直到找到跟b树跟a树相同的节点
    //难点2，找到出口
//    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        if(B==null&&A!=null) //B为空，但是A不为空，跳出
//            return false;
//        //先找到B的根节点与A中是否有相同的节点
//        Queue<TreeNode> queue=new LinkedList<>();
//        queue.add(A);
//        while (queue!=null){
//            TreeNode now=queue.remove();
//            if (B.val==now.val)//找到了A中与B相同的第一个节点
//            {
//                if (recur(now, B))
//                    return true;
//            }
//            if (now.left!=null)
//                queue.add(now.left);
//            if (now.right!=null)
//                queue.add(now.right);
//        }
//        return false;
//    }
//    private boolean isSonTree(TreeNode a, TreeNode b) {//此时a已经等于b了
//        if(b == null) return true;
//        if(a == null || a.val != b.val) return false;
//        return isSonTree(a.left,b.left)&&isSonTree(a.right,b.right);
//    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
