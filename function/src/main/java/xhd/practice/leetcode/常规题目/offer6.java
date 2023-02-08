package xhd.practice.leetcode.常规题目;
import java.util.Stack;

/*
    输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    输入：head = [1,3,2]
    输出：[2,3,1]
* */
public class offer6 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        int lenth=0;
        while (head!=null){
            lenth++;
            stack.add(head.val);
            head=head.next;
        }
        int a[]=new int[lenth];
        for (int i=0;i<lenth;i++){
            a[i]=stack.get(lenth-i-1);
        }
        return a;
}
}

