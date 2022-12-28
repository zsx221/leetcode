package xhd.practice.leetcode;

import lombok.val;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class offer32_1 {
    static class  TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(3);
        node.left=new TreeNode(9);
        node.right=new TreeNode(20);
        node.right.right=new TreeNode(7);
        node.right.left=new TreeNode(15);
        int[] ints = levelOrder(node);
        for (int anInt : ints) {
            System.out.print(anInt);
        }
    }
    public static int[] levelOrder(TreeNode root) {
        if (root==null)
            return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (queue .size()!=0) {
            TreeNode node = queue.remove();
            list.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }
}
