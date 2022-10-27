package xhd.practice.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
 * [[],[3],[],[],[]]
 * 输出：[null,null,3,-1,-1]
 */
public class offer09 {
    Deque<Integer> head;
    Deque<Integer> tail;
    public void CQueue() {
        head=new LinkedList<Integer>();
        tail=new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        tail.push(value);
    }

    public int deleteHead() {
        if (!head.isEmpty())return head.pop();//如果head栈不为空，就直接pop
        else {//head为空
            while (!tail.isEmpty())
                head.push(tail.pop());
            return head.pop()==null?-1:head.pop();
        }
    }
}
