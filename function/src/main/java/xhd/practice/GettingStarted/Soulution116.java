package xhd.practice.GettingStarted;

import lombok.val;

import java.util.Stack;

/**
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class Soulution116 {
    public static void main(String[] args) {
        Node root1=new Node(1);
        root1.left=new Node(2);
        root1.right=new Node(3);
        root1.left.left=new Node(4);
        root1.left.right=new Node(5);
        root1.right.left=new Node(6);
        root1.right.right=new Node(7);
        connect(root1);
    }

    public static Node connect(Node root) {
        if (root==null)
            return root;
        Stack<Node> stack=new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            if (node.left!=null){
                stack.add(node.left);
            }
            if (node.right!=null){
                node.next=node.right;
                stack.add(node.right);
            }
        }
        return root;
    }
  static   class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}
