package xhd.practice.leetcode;

import lombok.val;

import java.util.*;

public class offer32_3 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.right.right = new TreeNode(5);
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
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);
        int lenth = 1;
        while (queue.size() != 0) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
                for (int i = 1; i <= currentLevelSize; ++i) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if(lenth % 2 != 0){
                        if (node.left != null) {
                            stack.push(node.left);
                        }
                        if (node.right != null) {
                            stack.push(node.right);
                        }
                    }else {
                        if (node.right != null) {
                            stack.push(node.right);
                        }
                        if (node.left != null) {
                            stack.push(node.left);
                        }
                    }
                }
            int stack_size = stack.size();
            for (int i = 0; i < stack_size; i++) {
                queue.add(stack.pop());
            }
            lenth++;
            lists.add(level);
        }
        return lists;
    }
}
