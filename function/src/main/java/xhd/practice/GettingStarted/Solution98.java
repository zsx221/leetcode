package xhd.practice.GettingStarted;

import lombok.val;

import java.util.Stack;

public class Solution98 {
    public static long pre = Long.MIN_VALUE;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // 记录前一个节点
        TreeNode pre = null;
        while (stack.size() > 0 || root != null) {
            // 一直向左子树走，每一次将当前节点保存到栈中
            if (root != null) {
                stack.add(root);
                root = root.left;
            }
            // 当前节点为空，证明走到了最左边，从栈中弹出节点
            // 开始对右子树重复上述过程
            else {
                TreeNode cur = stack.pop();
                // 判断序列是否有序
                if (pre != null && cur.val <= pre.val) {
                    return false;
                }
                pre = cur;
                root = cur.right;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(6);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(7);

        System.out.println(isValidBST(treeNode));
    }
}
