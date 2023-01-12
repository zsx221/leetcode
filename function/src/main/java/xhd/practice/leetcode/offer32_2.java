package xhd.practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class offer32_2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.right = new TreeNode(7);
        node.right.left = new TreeNode(15);
        List<List<Integer>>  list = levelOrder(node);
        for (List<Integer> integerList : list) {
            for (Integer integer : integerList) {
                System.out.print(integer+",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ints = new ArrayList<>();
        ints.add(root.val);
        lists.add(ints);
        while (queue.size() != 0) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            lists.add(level);
        }
        return lists;
    }
}
