package xhd.practice.leetcode;

import java.util.Stack;

public class offer30MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    public offer30MinStack() {
        stack=new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int min() {
        return stack.stream().min(Integer::compare).get();
    }
}
