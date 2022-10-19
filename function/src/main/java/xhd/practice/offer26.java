package xhd.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
//递归

public class offer26 {
//    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        if (A==null)
//            return false;
//        if (B==null)
//            return false;
//        Queue<TreeNode> queue=new LinkedList<>();
//        Queue<TreeNode> queueB=new LinkedList<>();
//        queue.add(A);
//        queueB.add(B);
//        while (queue!=null){
//            TreeNode node=queue.remove();
//            TreeNode nodeB=queueB.peek();
//            if (node.val==nodeB.val)
//            {
//                queueB.remove();
//                if (nodeB.left!=null)
//                    queueB.add(nodeB.left);
//                if (nodeB.right!=null)
//                    queueB.add(nodeB.right);
//                if (queueB==null)
//                    return true;
//                //判断逻辑
//            }
//            if (node.left!=null)
//                queue.add(node.left);
//            if (node.right!=null)
//                queue.add(node.right);
//        }
//        return false;
//
//    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return compare(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
        public boolean compare(TreeNode A, TreeNode B){
            if(B == null) return true;
            if(A == null) return false;
            return A.val == B.val && compare(A.left, B.left) && compare(A.right, B.right);
        }
}
