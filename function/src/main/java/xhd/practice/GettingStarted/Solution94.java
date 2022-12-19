package xhd.practice.GettingStarted;

import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 * 左根右
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 */
public class Solution94 {
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

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //如果节点没有左孩子，则弹出栈顶节点，并将弹出的的节点加入到res中。访问节点的右孩子
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return  res;

    }
}
