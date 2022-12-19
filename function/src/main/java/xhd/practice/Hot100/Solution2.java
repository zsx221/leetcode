package xhd.practice.Hot100;

import lombok.val;

import java.util.Stack;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class Solution2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuffer buffer1 = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        buffer1 = getBuffer(l1);
        buffer2 = getBuffer(l2);
        String s = add(String.valueOf(buffer1), String.valueOf(buffer2));
        int length = s.length();
        ListNode out = new ListNode();
        ListNode head = out;
        for (int i = 0; i < length; i++) {
            out.next = new ListNode(Integer.parseInt(String.valueOf(s.charAt(length - i - 1))));
            out = out.next;
        }
        return head.next;
    }

    //自制加法器
    public static String add(String s1, String s2) {
        String result = "";//结果
        int c = 0;//进位值，例如两个个位数相加有进位，那么c表示的就是进位
        while (!s1.isEmpty() || !s2.isEmpty() || c > 0) {//如果两个整数以及进位都为空，那么就结束循环
            int num1 = 0;//第一个整数当前位的值，默认为0
            if (!s1.isEmpty()) {//如果第一个整数不为空
                num1 = Integer.parseInt(s1.substring(s1.length() - 1));//获取最后一个字符转换成整数
                s1 = s1.substring(0, s1.length() - 1);//获取后删除最后一个字符
            }

            int num2 = 0;//第二个整数当前位的值，默认为0
            if (!s2.isEmpty()) {
                num2 = Integer.parseInt(s2.substring(s2.length() - 1));
                s2 = s2.substring(0, s2.length() - 1);
            }

            int res = num1 + num2 + c;//计算两个整数当前位及进位的和
            result = res % 10 + result;//因为res可能会有进位，所以res可能会是两位数，所以只取个位，所以模10，然后再与之前的结果连接
            c = res / 10;//保存进位的结果，在下一次循环时使用。
        }
        return result;
    }

    static private StringBuffer getBuffer(ListNode l) {
        StringBuffer buffer = new StringBuffer();
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.add(l.val);
            l = l.next;
        }
        while (!stack.isEmpty()) {
            buffer.append(stack.pop());
        }
        return buffer;
    }

    public static void main(String[] args) {
//        ListNode node1=new ListNode(2);
//        node1.next=new ListNode(4);
//        node1.next.next=new ListNode(3);
//        ListNode node2=new ListNode(5);
//        node2.next=new ListNode(6);
//        node2.next.next=new ListNode(4);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(9);
        node2.next.next = new ListNode(9);
        node2.next.next.next = new ListNode(9);
        node2.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next = new ListNode(9);
        node2.next.next.next.next.next.next = new ListNode(9);
        ListNode listNode = addTwoNumbers(node1, node2);
        System.out.println();
    }
}
